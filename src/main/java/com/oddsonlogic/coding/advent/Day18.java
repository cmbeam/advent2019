package com.oddsonlogic.coding.advent;

import java.util.*;

public class Day18 {


    HashMap<String,String> keys = new HashMap<>();
    HashMap<String,String> doors = new HashMap<>();
    List<String> walls = new ArrayList<>();
    int height = 0;
    int width = 0;
    Coordinates start = new Coordinates();

    public static void main(String[] args) {
        String input = "#################################################################################\n" +
                "#.................C...#...#.......#.....#.#.........#.R.....#.....B............t#\n" +
                "#.###################.#.#.###.#.###.#.#V#.#.#####.#.#.#####.#.#####.###########.#\n" +
                "#...Z...#.......#.....#.#...#.#...#.#.#.#.#.#.#...#.#.#...#...#...#.#.....#.#...#\n" +
                "#.#####.#.#####.#.#####.###.#.###.#.#.###.#.#.#.#####.#.#.#####.#.#.#.###.#.#.###\n" +
                "#.#.....#k..#...#...#...#.#.#...#...#...#...#.#.......#.#.....#.#n#.....#.#...#.#\n" +
                "#.#.#.#####.#.#####.#.#.#.#.#.#########.#.###.#########.#.#####.#.#######.#.###.#\n" +
                "#.#.#.#.....#.#...F.#.#.#...#.#...#...#.#.#............m#.#.....#.......#.#.#...#\n" +
                "#.#.###.#####.#.#######.#.#####.#.#.#.#.#.#####.#####.#####.###########.#.#.#.#.#\n" +
                "#.#...#.#.....#...#.....#.......#.#.#.#.#.....#.#...#.#.....#.....#.......#.#.#.#\n" +
                "#.###.#.#.#######.#.#############.#.#.#.#####.#.#.#.###.#####.###.#########.#.#.#\n" +
                "#.#...#.#.......#.#...#...#.....#.#.#.#.#...#...#.#.#...#..q..#.#.#.....#.....#.#\n" +
                "#.#.###.#######.#.#.#.###.#.#.###.#.#.#.#.#.#.###.#.#.###.#####.#.#.###.#######.#\n" +
                "#.#...........#.#.#.#...#...#...#.#.#...#.#.#.#...#...#...#.....#...#.#w..#...#i#\n" +
                "#.###########.#.#.#####.#.#####.#.#.###U###.#.#.#######.###.#########.###.#.#.###\n" +
                "#...#.#.....#.#.#.......#.#...#.#.#...#.#...#.#.....#...#.........#.....#...#...#\n" +
                "###.#.#.###.#.#.#########.###.#.#.#.#.#.#.###.#####.#.#.#####.#.###.#.#########.#\n" +
                "#.#.#.#.#.#.#.#.#.......#.....#.#.#.#.#.#...#.#...#.#.#.#...#.#.#...#s......#...#\n" +
                "#.#.#.#.#.#.###.#####.#.#####.#.#.###.#.#.#.#.#.###.#.###.#.#.#.#.#######.###.###\n" +
                "#.....#.#.......#...#.#...#...#...#...#.#.#...#...#.#.....#.#.#...#..x..#....d#.#\n" +
                "#######.#########.#.#####.#.#######.###.#.#######.#.#######J###.###.###.#######.#\n" +
                "#.....#...#...#.S.#.#j..#...........#.#.#.#.......#.#.....#...#...#.#.#.#.#.....#\n" +
                "#.###.###.#.#.#.###.###.#############.#.#.#.#####.#.#.#.#########.#.#.#.#.#.#.#.#\n" +
                "#.#.....#.#.#.....#...#.......#.........#...#.....#...#.........#...#...#.#.#.#.#\n" +
                "#.#####.#.#.#######.#.#######.###.###########.###########.#.#########.###.#.#.###\n" +
                "#.#.E.#.#.#.#...#...#...#...#...#.....#.#.....#...........#.#.....#...#..e..#...#\n" +
                "#.#.#.#.#H#X#.#.#.#.#####W#.###Q#####.#.#.#####.###.#########.###.#.###########.#\n" +
                "#...#.#...#.#.#.#.#.#...#.#...#.#...#.#.#...#.#...#.#...#...#.#.#.#.............#\n" +
                "#####.#####.#.#.#.###.#.#.###.#.#.###.#.###.#.###.#.#.#.#.#.#.#.#.#############.#\n" +
                "#...#.#.....#.#.#...D.#...#.#.#.#.....#.#...#...#.#.#.#...#...#.#.#...........#.#\n" +
                "###.#.#.#####.#############.#.#.#.#####.#.#####.#.###.#########.#.#.###.#.#####.#\n" +
                "#...#...#..........o........#...#......g#.....#.#.....#...#.#...#.#.#.K.#.#....h#\n" +
                "#.#.#####.###########.#################.#####.#.#######.#.#.#.#.#.#.#.#####.#####\n" +
                "#.#.....#.#.....#...#.........#.......#.#.#...#.....#...#.#...#.#...#...#...#...#\n" +
                "#.#######.###.#.#.#.#######.#.#######.#.#.#.###.###.#.###.#####.#######.#.#####.#\n" +
                "#.#.....#...#.#...#...#...#.#.........#.#.#...#...#.#.#...........#.....#.....#.#\n" +
                "#.#.###.###.#.#######.#.###.#####.#####.#.###.#.#.#.#.###########.#.#########.#.#\n" +
                "#.#.#.#...#...#.#.....#...#.....#.#.....#.#...#.#.#.#...#.........#.#.........#.#\n" +
                "#.#.#.###.#####.#.#######.#####.###.#####.#.#####.#.###.#.#########.#.#########.#\n" +
                "#.......#.....................#...................#.....#.........#.............#\n" +
                "#######################################.@.#######################################\n" +
                "#.......#...........#.....#.....................#.....#.......#...........#.....#\n" +
                "#.#######.#.#######.#.###.#.#####.#####.#.#.#####.#.#.#######.#.#########.#####.#\n" +
                "#.#.......#.....#...#...#.#.#...#.....#.#.#.......#.#.........#.#.......#...#...#\n" +
                "#.#.###########.#.#####.###.#.#.#####.#.#.#####.###.###########.#.###.#.###.#.###\n" +
                "#b..#...........#.....#...#.#.#.#.#...#.#.#...#...#...#.........#.#...#.#...#...#\n" +
                "#.###.###############.###.#.#.#.#.#.###.###.#.#######.#.#########.#.#.###.#####.#\n" +
                "#...#...........#...#.#...#.#.#...#.#...#...#.......#.#.#.......#.#.#.#...#.....#\n" +
                "###.###########.###.#.#.#.#.#.###.#.###.#.#########.#.#.#.#####.###.#.#.###.###.#\n" +
                "#.............#...#.....#.#...#...#...#.#.#.#.....#.#.#.#.#...#.....#.#....l#...#\n" +
                "#.#########.#####.#####.#######.#####G#.#.#.#.#O###.#.#.#.#.#.#.#####.#######.###\n" +
                "#.#...#...#.#...#...#...#.....#...#...#.#.#.#.#...#...#.#.#.#.#.#.Y.#.......#.#.#\n" +
                "#.#.#.#.#.###.#.#.#.###.#.###.###.#.###.#.#.#.###.#.###.#.#.#.###.#.#######.#.#.#\n" +
                "#.#.#a..#.....#.#.#...#.#.#.#.....#.#.#.#.#.#...#...#...#.#.#.....#.....#...#.#.#\n" +
                "###.###########.#####.###.#.#####.#.#.#.#.#.###.#####.###.#.###########.#.###.#.#\n" +
                "#...#..y#.....#.#...#.......#...#.#.#...#.#.........#.#.......#.#.......#.#...#.#\n" +
                "#.###.#.#.#.#.#.#.#.#.#######.#.#.#.###.#.#.#########.#######.#.#.#######.#.###.#\n" +
                "#.....#.#.#.#.#...#.#.#.......#.#.#...#.#.#.#.......#.....#z#.#.#.#.....#.#p..#.#\n" +
                "#######.###.#######.#.#.#######.#####.###.###.#####.#####.#.#.#.#A#.###.#.###.#.#\n" +
                "#.....#.....#.....#.#.#.....#.......#...#...#...#.....#...#.....#.#...#.....#.#.#\n" +
                "#.###.#####.#.###.#.#######.#######.###.#.#.#.###.###.#.#######.#.#.#########.#.#\n" +
                "#...#.......#.#.#...#.....#...#...#...#.#.#...#...#...#.......#.#.#.#.........#.#\n" +
                "###.#########.#.#.#######.#.#.###.###.#.#.#####.###.###########.#.###.#########.#\n" +
                "#...#...#...P.#...#.......#.#...#.#...#.#.#.....#...#.......#.#.#.....#...#.....#\n" +
                "#.###.###.###.#####.#########.#.#.#.###.#.#.#######.#.#####.#.#.#######.#.#####.#\n" +
                "#.....#...#...#.....#.......#.#.#...#...#.#.......#...#...#...#.#.......#.......#\n" +
                "#####.#.###.###.#####.#####.###.###.#.#.#.#######.#####.#.###.#.###.###.#########\n" +
                "#...#c#...#.#...#.....#...#...#...#.#.#u#.#.....#.....#.#.....#...#...#.#.......#\n" +
                "###.#.###.###.###.#####.#####.###.#.#.#.#.#.###.#####.#.#########.###.#.#.#####.#\n" +
                "#...#...#.L.#.#.#...#.......#.#...#...#.#.#.#.#.#...#.#.....#...#.#...#.......#.#\n" +
                "#.#####.###.#.#.#.#.#.#####.#.#.#######.#.#.#.#.###.#.#####.#.#.#.#.#####.#####.#\n" +
                "#...#...#.#...#...#.#.....#.#.#.#.....#.#.#.#.#.....#...#...#.#...#.#...#.#...#.#\n" +
                "###.#.###.#########.###.###.#.#.#####.#.#.#.#.#####.###.#.###.#######.#.###.#.#.#\n" +
                "#...#...#.........#...#.#...#...#.....#.#...#.#...#.#.#.#.#...#.....#.#...N.#.#.#\n" +
                "#.#####.#.#####.#.###.#.#.#######.#####.#####.#.#.#.#.#.###.###.###.#.#######.#T#\n" +
                "#.I.#...#.#.....#.....#.#...#...#.......#.#.....#.#.#.#...#.#.....#...#...#...#.#\n" +
                "#.#.#.###.#.###############.#.#.#.#######.#.#####.#.#.###.#.#####.#####.#.#.###.#\n" +
                "#.#...#...#.#.....#.........#.#.#...#...#...#...#.#.#...#.#f......#.#...#.#.....#\n" +
                "#.#########.#.#####.###.#####.#.###.#.#.#.###.#.#.#.###.#.#########.#.#.#######.#\n" +
                "#...........#..r....M.#.......#v......#.#.....#.#.......#.............#.........#\n" +
                "#################################################################################";
/*
        input="#########\n" +
                "#b.A.@.a#\n" +
                "#########";

       input="########################\n" +
               "#f.D.E.e.C.b.A.@.a.B.c.#\n" +
               "######################.#\n" +
               "#d.....................#\n" +
               "########################";


       input="########################\n" +
               "#...............b.C.D.f#\n" +
               "#.######################\n" +
               "#.....@.a.B.c.d.A.e.F.g#\n" +
               "########################";

       input="#################\n" +
               "#i.G..c...e..H.p#\n" +
               "########.########\n" +
               "#j.A..b...f..D.o#\n" +
               "########@########\n" +
               "#k.E..a...g..B.n#\n" +
               "########.########\n" +
               "#l.F..d...h..C.m#\n" +
               "#################";

 */

        List<String> items = Arrays.asList(input.split("\n"));
        Day18 day18 = new Day18();
        day18.height = items.size();
        day18.width = items.get(0).length();
        System.out.println("width: "+day18.width+" Height: "+day18.height);



        //Parse maze
        int y = 0;
        for (String item: items) {
            for (int i = 0; i <day18.width ; i++) {
                Coordinates coordinate = new Coordinates();
                coordinate.x=i;
                coordinate.y=y;
                char waypoint = item.charAt(i);
                //lower case = key
                if(Character.isLowerCase(waypoint))
                    day18.keys.put(coordinate.toString(),""+waypoint);
                //upper case = door
                else if(Character.isUpperCase(waypoint))
                    day18.doors.put(coordinate.toString(),""+waypoint);
                //# = wall
                else if(waypoint=='#')
                    day18.walls.add(coordinate.toString());
                else if(waypoint=='@')
                    day18.start=coordinate;
            }
            y++;
        }

        //Print maze to verify
        day18.printMaze();

        int stepCounter = 0;

        Coordinates currentLocation = day18.start;
        //while doors exist
        while(day18.keys.size() > 0) {


            //shortest distance to all accessible keys and accessible unlockable doors
            Coordinates closest = new Coordinates();
            int smallestPath = 0;
            for (Map.Entry<String,String> key : day18.keys.entrySet()) {
                int path = day18.findShortestPath(currentLocation,Coordinates.stringValue(key.getKey()));
                if(path > smallestPath){
                    smallestPath = path;
                    closest = Coordinates.stringValue(key.getKey());
                }
            }


            stepCounter = stepCounter + smallestPath;
            currentLocation = closest;

            System.out.println(day18.keys.get(currentLocation.toString())+" Steps: "+stepCounter);
            day18.keys.remove(closest.toString());

        }




        System.out.println();
        System.out.println();
        System.out.println("Steps: "+stepCounter);

    }
    public  void printMaze(){
        for (int i = 0; i <this.height ; i++) {
            for (int j = 0; j < this.width ; j++) {
                Coordinates coordinate = new Coordinates();
                coordinate.x=j;
                coordinate.y=i;
                if(walls.contains(coordinate.toString()))
                    System.out.print("#");
                else if(keys.containsKey(coordinate.toString()))
                    System.out.print(keys.get(coordinate.toString()));
                else if(doors.containsKey(coordinate.toString()))
                    System.out.print(doors.get(coordinate.toString()));
                else if(coordinate.x==start.x&&coordinate.y==start.y)
                    System.out.print("@");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public boolean endpointAvailable(Coordinates endpoint){

        if(keys.containsKey(endpoint.toString()))
            return true;
        else if(doors.containsKey(endpoint.toString())){
            String door = doors.get(endpoint.toString());
            String key = door.toLowerCase();
            if(keys.containsValue(key))
                return false;
            else
                return true;
        }
        return true;
    }

    public boolean isEmpty(Coordinates endpoint) {
        if(keys.containsKey(endpoint.toString()))
            return false;
        else if(doors.containsKey(endpoint.toString())) {
            if(keys.containsValue(""+Character.toLowerCase(doors.get(endpoint.toString()).charAt(0)))) {
                return false;
            }
            else
                return true;
        }
        else if(walls.contains(endpoint.toString()))
            return false;
        else
            return true;


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
    static class QueueNode
    {
        Point pt; // The cordinates of a cell
        int dist; // cell's distance of from the source

        public QueueNode(Point pt, int dist)
        {
            this.pt = pt;
            this.dist = dist;
        }
    };

    // check whether given cell (row, col)
    // is a valid cell or not.
    static boolean isValid(int row, int col,int rowMax, int colMax)
    {
        // return true if row number and
        // column number is in range
        return (row >= 0) && (row < rowMax) &&
                (col >= 0) && (col < colMax);
    }


    static int rowNum[] = {1, -1, 0, 0};
    static int colNum[] = {0, 0, -1, 1};



    public int findShortestPath(Coordinates startPoint, Coordinates endPoint)
    {

        boolean [][]visited = new boolean[width][height];

        // Mark the source cell as visited
        visited[startPoint.x][startPoint.y] = true;


        Queue<QueueNode> queue = new LinkedList<>();

        // Distance of start point is 0
        QueueNode node = new QueueNode(new Point(startPoint.x,startPoint.y), 0);
        queue.add(node); // Enqueue source cell
        while (!queue.isEmpty())
        {
            QueueNode curr = queue.peek();
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
                int row = pt.y + rowNum[i];
                int col = pt.x + colNum[i];

                Coordinates currPoint = new Coordinates();
                currPoint.x = col;
                currPoint.y = row;
                // if adjacent cell is valid, has path
                // and not visited yet, enqueue it.

                if(isValid(row, col, height, width) && !visited[col][row] && endPoint.x == col && endPoint.y == row) {

                    return curr.dist+1;
                }
                if (isValid(row, col, height, width) && !visited[col][row]  && isEmpty(currPoint))
                {
                    // mark cell as visited and enqueue it

                    visited[col][row] = true;
                    QueueNode Adjcell = new QueueNode(new Point(col, row),
                            curr.dist + 1);
                    queue.add(Adjcell);

                }

            }

        }

        // Return -1 if destination cannot be reached
        return -1;//99999999;
    }

}
