package com.oddsonlogic.coding.advent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day15 extends Canvas {

    static int ROW = 400;
    static int COL = 400;

    static boolean INTERACTIVE_MODE = true;
    static int SCREEN_WIDTH = 200;
    static int SCREEN_HEIGHT = 200;
    int refreshRate = 1;
    int joystick = 0;
    String[][] grid = new String[SCREEN_WIDTH][SCREEN_HEIGHT];
    OpcodeComputer computer;

    public Day15() {
        setSize(new Dimension(500, 500));
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        if(INTERACTIVE_MODE)
                            computer.inputs.add(3);
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(INTERACTIVE_MODE)
                            computer.inputs.add(4);
                        break;
                    case KeyEvent.VK_DOWN:
                        if(INTERACTIVE_MODE)
                            computer.inputs.add(2);
                        break;
                    case KeyEvent.VK_UP:
                        if(INTERACTIVE_MODE)
                            computer.inputs.add(1);
                        break;

                    default:
                        joystick=0;
                }

            }
        });
    }
    public static int windowY(){
        return SCREEN_HEIGHT;
    }

    public static int windowX(){
        return SCREEN_WIDTH;
    }

    public void paint(Graphics g) {

        for (int y = 0; y < SCREEN_HEIGHT; y++) {
            for (int x = 0; x < SCREEN_WIDTH; x++) {
                g.drawString(grid[x][y], x*10, y*10);
            }
        }

    }



    public static void main(String[] args) {

        Day15 ex = new Day15();

 /*       JFrame frame = new JFrame("Intcode Repair Robot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(ex);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        ex.requestFocus();

  */

        boolean completed = false;
        int count = 0;



        String program = "3,1033,1008,1033,1,1032,1005,1032,31,1008,1033,2,1032,1005,1032,58,1008,1033,3,1032,1005,1032,81,1008,1033,4,1032,1005,1032,104,99,101,0,1034,1039,1002,1036,1,1041,1001,1035,-1,1040,1008,1038,0,1043,102,-1,1043,1032,1,1037,1032,1042,1105,1,124,1001,1034,0,1039,101,0,1036,1041,1001,1035,1,1040,1008,1038,0,1043,1,1037,1038,1042,1105,1,124,1001,1034,-1,1039,1008,1036,0,1041,102,1,1035,1040,1001,1038,0,1043,101,0,1037,1042,1106,0,124,1001,1034,1,1039,1008,1036,0,1041,101,0,1035,1040,1002,1038,1,1043,101,0,1037,1042,1006,1039,217,1006,1040,217,1008,1039,40,1032,1005,1032,217,1008,1040,40,1032,1005,1032,217,1008,1039,33,1032,1006,1032,165,1008,1040,35,1032,1006,1032,165,1101,0,2,1044,1105,1,224,2,1041,1043,1032,1006,1032,179,1101,0,1,1044,1106,0,224,1,1041,1043,1032,1006,1032,217,1,1042,1043,1032,1001,1032,-1,1032,1002,1032,39,1032,1,1032,1039,1032,101,-1,1032,1032,101,252,1032,211,1007,0,68,1044,1105,1,224,1101,0,0,1044,1106,0,224,1006,1044,247,101,0,1039,1034,102,1,1040,1035,1001,1041,0,1036,102,1,1043,1038,101,0,1042,1037,4,1044,1105,1,0,30,84,39,21,27,93,20,65,45,95,19,6,71,25,33,13,80,53,60,70,65,80,45,65,53,62,93,13,19,72,33,49,54,92,9,29,25,69,7,46,9,96,97,70,8,69,71,97,3,75,94,49,96,11,76,24,29,84,87,99,33,76,83,83,21,62,97,82,63,71,78,74,29,94,90,34,92,58,75,44,66,99,28,37,84,18,18,94,86,50,4,74,3,96,74,39,99,55,93,44,94,55,40,78,2,88,70,6,69,67,87,40,4,93,76,30,1,42,40,87,23,83,89,24,73,19,62,88,43,92,94,50,71,53,19,75,22,9,82,46,65,84,92,63,99,57,23,62,93,61,14,87,67,84,90,38,96,83,33,63,40,80,75,10,79,89,52,14,97,32,87,72,57,79,7,79,6,93,66,77,50,19,97,78,65,96,24,94,80,12,10,70,9,60,77,67,17,83,76,36,79,27,43,91,6,72,77,49,4,47,56,85,81,11,46,96,93,33,82,44,69,49,34,98,77,95,38,19,85,1,62,73,49,95,39,62,36,83,23,93,34,32,21,94,89,30,85,76,13,92,87,3,84,43,3,74,39,81,6,85,16,69,89,21,56,80,65,92,84,97,7,63,23,8,87,37,70,54,75,92,95,96,51,83,34,24,86,39,59,48,89,45,34,89,72,3,77,63,98,38,70,39,38,98,97,85,46,96,53,81,89,27,83,75,31,81,71,39,81,62,79,11,78,18,90,94,1,91,1,79,77,74,64,20,73,55,75,78,2,77,24,92,56,55,25,70,21,38,69,49,81,19,34,92,97,74,61,79,18,77,51,76,62,92,10,85,83,87,39,90,31,98,95,61,32,63,82,59,75,65,53,72,91,17,75,75,54,85,57,32,13,39,70,48,86,59,50,96,32,23,84,61,85,48,59,92,33,15,58,83,95,48,80,70,84,58,69,70,37,99,18,73,79,32,71,22,41,75,26,71,25,55,73,31,5,53,71,95,65,87,50,62,95,80,54,95,73,79,20,94,65,83,33,26,88,3,11,99,76,93,28,97,67,49,90,94,19,85,28,10,96,70,55,84,17,75,33,47,91,44,88,96,1,6,89,40,69,27,58,98,61,25,77,79,43,83,38,13,72,44,99,20,33,69,8,5,47,72,78,24,53,94,78,39,99,87,9,63,82,52,69,64,48,93,46,48,89,22,84,32,69,7,36,99,80,4,27,92,54,14,85,56,19,99,93,99,49,67,82,90,23,10,77,77,37,79,67,78,27,81,79,34,67,81,40,88,76,89,94,64,80,73,79,57,72,22,14,93,3,88,84,88,41,12,29,4,97,57,83,38,93,51,55,20,75,57,78,22,76,22,24,85,91,79,27,19,46,90,18,71,3,39,28,26,94,87,83,31,35,73,56,99,83,35,65,92,45,98,93,2,73,88,15,90,62,85,95,20,96,75,52,4,62,81,78,49,67,69,20,5,85,72,79,45,34,73,89,20,37,60,79,97,6,41,78,40,70,42,29,89,21,76,88,44,82,17,9,73,52,71,73,25,89,71,30,82,85,26,86,61,43,7,71,13,99,72,40,95,79,39,67,39,65,90,91,14,96,20,73,98,66,13,92,70,1,93,2,86,45,54,85,73,30,62,14,97,89,39,77,99,40,89,76,49,97,42,60,97,62,82,35,98,49,80,15,91,34,87,65,77,44,93,65,87,76,82,20,78,46,90,18,81,73,98,47,99,48,69,2,82,90,90,47,85,49,94,37,81,76,90,0,0,21,21,1,10,1,0,0,0,0,0,0";

        ex.computer = new OpcodeComputer(program, 1000);

        System.out.println(findShortestPath(ex.computer));
        /*
        int paddleCoord = 0;
        int positionX = SCREEN_WIDTH/2;
        int positionY = SCREEN_HEIGHT/2;

        int score = 0;

        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
                ex.grid[j][i] = " ";
            }
        }
        int direction = 1;
        ex.computer.inputs.add(2);




        //Part 1 int blockCount = 0;

    while (!ex.computer.done && !completed) {
        count++;
            //ex.computer.inputs.add(ex.joystick);

               // Scanner scan = new Scanner(System.in);
               // int input = scan.nextInt();
                //ex.computer.inputs.add(input);
            ex.computer.inputs.add(direction);


            if(ex.computer.inputs.size()>0) {
                int newPositionY = positionY;
                int newPositionX = positionX;
                switch (ex.computer.inputs.get(0)){
                    case 1:
                        newPositionY++;
                        break;
                    case 2:
                        newPositionY--;
                        break;
                    case 3:
                        newPositionX--;
                        break;
                    case 4:
                        newPositionX++;
                        break;
                    default:
                        break;


                }
                int status = ex.computer.compute().intValue();


                    switch (status) {
                        case 0:
                            //System.out.println("wall");
                            ex.grid[newPositionX][newPositionY] = "#";
                            ex.grid[positionX][positionY] = "D";
                            direction = goRight(direction);
                            break;
                        case 1:
                            //System.out.println("clear");
                            ex.grid[newPositionX][newPositionY] = "D";
                            ex.grid[positionX][positionY] = ".";
                            positionX = newPositionX;
                            positionY = newPositionY;
                            direction = goLeft(direction);
                            break;
                        case 2:
                            System.out.println("Oxygen found. Number of moves: "+count );
                            ex.grid[newPositionX][newPositionY] = "O";
                            ex.grid[positionX][positionY] = ".";
                            ex.grid[SCREEN_WIDTH/2][SCREEN_HEIGHT/2] = "S";
                            completed = true;
                            break;

                        default:
                            break;
                    }



                try {
                    Thread.sleep(ex.refreshRate);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }

         */

/*
                for (int i = SCREEN_HEIGHT-1; i >= 0; i--) {
                    for (int j = 0; j < SCREEN_WIDTH; j++) {
                        System.out.print(ex.grid[j][i]);
                    }
                    System.out.println();
                }
                */

/*
                //ex.repaint();



                //Part 1 if(tile==2)
                //blockCount++;
            }

        }
        for (int i = SCREEN_HEIGHT-1; i >= 0; i--) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
                System.out.print(ex.grid[j][i]);
            }
            System.out.println();
        }
        //System.out.println("Score:   " + score);

        //Part 1 System.out.println("Number of blocks: "+blockCount);

*/

        }


    static int goRight(int direction) {
        switch (direction){
            case 1:
                return 4;
            case 2:
                return 3;

            case 3:
                return 1;

            case 4:
                return 2;

                default:
                    return 0;
        }

    }

    static int goLeft(int direction) {
        switch (direction){
            case 1:
                return 3;
            case 2:
                return 4;

            case 3:
                return 2;

            case 4:
                return 1;

            default:
                return 0;
        }

    }


    static class Point
    {
        int x;
        int y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    };

    // A Data Structure for queue used in BFS
    static class queueNode
    {
        Point pt; // The cordinates of a cell
        int dist; // cell's distance of from the source

        public queueNode(Point pt, int dist)
        {
            this.pt = pt;
            this.dist = dist;
        }
    };

    // check whether given cell (row, col)
// is a valid cell or not.
    static boolean isValid(int row, int col)
    {
        // return true if row number and
        // column number is in range
        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL);
    }


    static int rowNum[] = {1, -1, 0, 0};
    static int colNum[] = {0, 0, -1, 1};


    static int findShortestPath(OpcodeComputer computer)
    {

        boolean [][]visited = new boolean[ROW][COL];

        // Mark the source cell as visited
        //visited[src.x][src.y] = true;

        // Create a queue for BFS
        Queue<queueNode> queue = new LinkedList<>();

        // Distance of start point is 0
        queueNode s = new queueNode(new Point(100,100), 0);
        queue.add(s); // Enqueue source cell

        while (!queue.isEmpty())
        {
            queueNode curr = queue.peek();
            Point pt = curr.pt;

            // If we have reached the destination cell,
            // we are done
            //if (pt.x == dest.x && pt.y == dest.y)
            //    return curr.dist;

            // Otherwise dequeue the front cell
            // in the queue and enqueue
            // its adjacent cells
            queue.remove();

            for (int i = 0; i < 4; i++)
            {
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];

                // if adjacent cell is valid, has path
                // and not visited yet, enqueue it.
                computer.inputs.add(i+1);
                BigInteger status = computer.compute();
                if(status.intValue() == 2)
                    return curr.dist;
                if (!visited[row][col] && status.equals( BigInteger.valueOf(1)))
                {
                    // mark cell as visited and enqueue it
                    visited[row][col] = true;
                    queueNode Adjcell = new queueNode(new Point(row, col),
                            curr.dist + 1 );
                    queue.add(Adjcell);
                }
            }
        }

        // Return -1 if destination cannot be reached
        return -1;
    }
}
