package com.oddsonlogic.coding.advent;

import java.math.BigInteger;

public class Day11 {
    public static void main(String[] args) {
        OpcodeComputer computer = new OpcodeComputer();
        computer.program="3,8,1005,8,351,1106,0,11,0,0,0,104,1,104,0,3,8,102,-1,8,10,1001,10,1,10,4,10,108,1,8,10,4,10,102,1,8,28,3,8,1002,8,-1,10,101,1,10,10,4,10,1008,8,0,10,4,10,1002,8,1,51,1006,0,85,2,1109,8,10,3,8,1002,8,-1,10,101,1,10,10,4,10,1008,8,0,10,4,10,102,1,8,80,1,2,2,10,1,1007,19,10,1,1001,13,10,3,8,1002,8,-1,10,1001,10,1,10,4,10,108,1,8,10,4,10,1001,8,0,113,1,2,1,10,1,1109,17,10,1,108,20,10,2,1005,3,10,3,8,102,-1,8,10,1001,10,1,10,4,10,108,1,8,10,4,10,1002,8,1,151,2,5,19,10,1,104,19,10,1,109,3,10,1006,0,78,3,8,102,-1,8,10,1001,10,1,10,4,10,1008,8,0,10,4,10,1002,8,1,189,1006,0,3,2,1004,1,10,3,8,1002,8,-1,10,101,1,10,10,4,10,1008,8,1,10,4,10,1001,8,0,218,1,1008,6,10,1,104,8,10,1006,0,13,3,8,1002,8,-1,10,101,1,10,10,4,10,1008,8,0,10,4,10,102,1,8,251,1006,0,17,1006,0,34,1006,0,24,1006,0,4,3,8,102,-1,8,10,1001,10,1,10,4,10,1008,8,0,10,4,10,102,1,8,285,1006,0,25,2,1103,11,10,1006,0,75,3,8,1002,8,-1,10,1001,10,1,10,4,10,108,1,8,10,4,10,101,0,8,316,2,1002,6,10,1006,0,30,2,106,11,10,1006,0,21,101,1,9,9,1007,9,1072,10,1005,10,15,99,109,673,104,0,104,1,21101,0,937151009684,1,21101,0,368,0,1105,1,472,21102,386979963796,1,1,21102,379,1,0,1106,0,472,3,10,104,0,104,1,3,10,104,0,104,0,3,10,104,0,104,1,3,10,104,0,104,1,3,10,104,0,104,0,3,10,104,0,104,1,21101,179410325723,0,1,21101,426,0,0,1106,0,472,21101,0,179355823195,1,21102,437,1,0,1106,0,472,3,10,104,0,104,0,3,10,104,0,104,0,21101,0,825460785920,1,21101,460,0,0,1105,1,472,21102,1,838429614848,1,21102,1,471,0,1105,1,472,99,109,2,21202,-1,1,1,21102,40,1,2,21102,1,503,3,21101,493,0,0,1105,1,536,109,-2,2106,0,0,0,1,0,0,1,109,2,3,10,204,-1,1001,498,499,514,4,0,1001,498,1,498,108,4,498,10,1006,10,530,1101,0,0,498,109,-2,2106,0,0,0,109,4,2101,0,-1,535,1207,-3,0,10,1006,10,553,21101,0,0,-3,21202,-3,1,1,22101,0,-2,2,21101,0,1,3,21101,572,0,0,1105,1,577,109,-4,2105,1,0,109,5,1207,-3,1,10,1006,10,600,2207,-4,-2,10,1006,10,600,21202,-4,1,-4,1106,0,668,21202,-4,1,1,21201,-3,-1,2,21202,-2,2,3,21102,619,1,0,1105,1,577,22102,1,1,-4,21101,0,1,-1,2207,-4,-2,10,1006,10,638,21101,0,0,-1,22202,-2,-1,-2,2107,0,-3,10,1006,10,660,22101,0,-1,1,21101,660,0,0,106,0,535,21202,-2,-1,-2,22201,-4,-2,-4,109,-5,2105,1,0";
        computer.extraMemory=10000;

        int GRID_X_DIMENSION = 50000;
        int GRID_Y_DIMENSION = 50000;
        int[][] grid = new int[GRID_X_DIMENSION][GRID_Y_DIMENSION];
        for (int i = 0; i <GRID_X_DIMENSION ; i++) {
            for (int j = 0; j < GRID_Y_DIMENSION; j++) {
                grid[i][j] = 2;
            }

        }
        int x = GRID_X_DIMENSION/2;
        int y = GRID_Y_DIMENSION/2;
        int direction = 0; //0-up, 1-right,2-down,3-left



        computer.inputs.add(0);
        while(!computer.done) {
            BigInteger output1 = computer.compute();
            BigInteger output2 = computer.compute();
            System.out.println("Output1: " + output1+" Output2: "+output2);

            //Paint square
            grid[x][y]=output1.intValue();

            //Move
            switch (direction){
                case 0:
                    if(output2.intValue() == 0) {
                        direction = 3;
                        x--;
                        System.out.println("Go left");
                    }
                    else {
                        direction = 1;
                        x++;
                        System.out.println("Go right");
                    }
                    break;
                case 1:
                    if(output2.intValue() == 0) {
                        direction = 0;
                        y++;
                        System.out.println("Go up");
                    }
                    else {
                        direction = 2;
                        y--;
                        System.out.println("Go down");
                    }
                    break;
                case 2:
                    if(output2.intValue() == 0) {
                        direction = 1;
                        x++;
                        System.out.println("Go right");
                    }
                    else {
                        direction = 3;
                        x--;
                        System.out.println("Go left");
                    }
                    break;
                case 3:
                    if(output2.intValue() == 0) {
                        direction = 2;
                        y--;
                        System.out.println("Go down");
                    }
                    else {
                        direction = 0;
                        y++;
                        System.out.println("Go up");
                    }
                    break;
                default:
                    break;
            }
            System.out.println("Grid location: "+x+","+y+"    "+direction);

            if(grid[x][y] == 2)
                computer.inputs.add(0);
            else
                computer.inputs.add(grid[x][y]);

        }
        System.out.println("computer done");

        int count = 0;
        for (int i = 0; i <GRID_X_DIMENSION ; i++) {
            for (int j = 0; j < GRID_Y_DIMENSION; j++) {
                if(grid[i][j] != 2)
                    count++;
            }
        }

        System.out.println("Panels painted: "+count);
    }
}
