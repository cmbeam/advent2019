package com.oddsonlogic.coding.advent;

import com.google.common.collect.Multimap;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.map.MultiValueMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Day10 {
    public static void main(String[] args) {

        String data=".#......##.#..#.......#####...#..\n" +
                "...#.....##......###....#.##.....\n" +
                "..#...#....#....#............###.\n" +
                ".....#......#.##......#.#..###.#.\n" +
                "#.#..........##.#.#...#.##.#.#.#.\n" +
                "..#.##.#...#.......#..##.......##\n" +
                "..#....#.....#..##.#..####.#.....\n" +
                "#.............#..#.........#.#...\n" +
                "........#.##..#..#..#.#.....#.#..\n" +
                ".........#...#..##......###.....#\n" +
                "##.#.###..#..#.#.....#.........#.\n" +
                ".#.###.##..##......#####..#..##..\n" +
                ".........#.......#.#......#......\n" +
                "..#...#...#...#.#....###.#.......\n" +
                "#..#.#....#...#.......#..#.#.##..\n" +
                "#.....##...#.###..#..#......#..##\n" +
                "...........#...#......#..#....#..\n" +
                "#.#.#......#....#..#.....##....##\n" +
                "..###...#.#.##..#...#.....#...#.#\n" +
                ".......#..##.#..#.............##.\n" +
                "..###........##.#................\n" +
                "###.#..#...#......###.#........#.\n" +
                ".......#....#.#.#..#..#....#..#..\n" +
                ".#...#..#...#......#....#.#..#...\n" +
                "#.#.........#.....#....#.#.#.....\n" +
                ".#....#......##.##....#........#.\n" +
                "....#..#..#...#..##.#.#......#.#.\n" +
                "..###.##.#.....#....#.#......#...\n" +
                "#.##...#............#..#.....#..#\n" +
                ".#....##....##...#......#........\n" +
                "...#...##...#.......#....##.#....\n" +
                ".#....#.#...#.#...##....#..##.#.#\n" +
                ".#.#....##.......#.....##.##.#.##";

        //data=   ".#..#\n" +".....\n" +"#####\n" +"....#\n" +"...##";

        /*
        data=".#..##.###...#######\n" +
                "##.############..##.\n" +
                ".#.######.########.#\n" +
                ".###.#######.####.#.\n" +
                "#####.##.#.##.###.##\n" +
                "..#####..#.#########\n" +
                "####################\n" +
                "#.####....###.#.#.##\n" +
                "##.#################\n" +
                "#####.##.###..####..\n" +
                "..######..##.#######\n" +
                "####.##.####...##..#\n" +
                ".#####..#.######.###\n" +
                "##...#.##########...\n" +
                "#.##########.#######\n" +
                ".####.#.###.###.#.##\n" +
                "....##.##.###..#####\n" +
                ".#.#.###########.###\n" +
                "#.#.#.#####.####.###\n" +
                "###.##.####.##.#..##"; */

        List<Coordinates> asteroids = new ArrayList<>();
        int mostAsteroids = 0;
        Coordinates bestAsteroid = new Coordinates();

        List<String> dataArray = Arrays.asList(data.split("\n"));
        //int y = dataArray.size() - 1;
        int y = 0;
        for (String line : dataArray) {
            for (int i = 0; i < line.length() ; i++) {
                if(line.charAt(i)=='#') {
                    Coordinates coord = new Coordinates();
                    coord.x = i;
                    coord.y = y;
                    asteroids.add(coord);
                }
            }
            y++;

        }

        for (Coordinates asteroid: asteroids) {
             System.out.println("x :  "+asteroid.x+"  y : "+asteroid.y);
            List<String> lineOfSight = new ArrayList<>();
            for (Coordinates candidateAsteroid: asteroids) {
                String vector = ""+slope(asteroid,candidateAsteroid)+" "+direction(asteroid,candidateAsteroid);
                //System.out.println(vector);
                String angle = ""+angle(asteroid,candidateAsteroid);
                //System.out.println("Vector: "+vector+"   Angle: "+angle);
                if(!lineOfSight.contains(angle))
                        lineOfSight.add(angle);
            }
            System.out.println("Line of sight number: "+(lineOfSight.size()));
            if((lineOfSight.size()) >= mostAsteroids) {
                bestAsteroid = asteroid;
                mostAsteroids = lineOfSight.size();
            }

        }

        System.out.println("Largest number: " + (mostAsteroids-1) + " from: "+bestAsteroid.x + ","+bestAsteroid.y);




        //PART 2
        Coordinates winnerAsteroid = new Coordinates();
        winnerAsteroid.x  = bestAsteroid.x;// 29;
        winnerAsteroid.y =bestAsteroid.y;// 4;
        Coordinates finalAsteroid = new Coordinates();
        HashMap<String,List<Coordinates>> otherAsteroids = new HashMap<>();
        for (Coordinates candidateAsteroid: asteroids) {
            String angle = ""+angle(winnerAsteroid,candidateAsteroid);
            if(!(candidateAsteroid.x ==0 && candidateAsteroid.y==0)) {
                if (!otherAsteroids.containsKey(angle)) {
                    List<Coordinates> list = new ArrayList<>();
                    list.add(candidateAsteroid);
                    otherAsteroids.put(angle, list);
                } else {
                    List<Coordinates> list = otherAsteroids.get(angle);
                    list.add(candidateAsteroid);
                }
            }
        }

        int count = 0;
        boolean done = false;
        while(!done){
            for (int i = 0; i  <3600000 ; i++) {
                if(otherAsteroids.containsKey(""+i)) {
                    count++;

                    //finalAsteroid = otherAsteroids.get("" + i).remove(0);
                    List<Coordinates> candidates = otherAsteroids.get(""+i);
                    System.out.println(count+"Vaporized: "+candidates.get(0).x+","+candidates.get(0).y+" "+i+"    "+candidates.size());
                    //System.out.println((count) + "Asteroid Vaporized: "+finalAsteroid.x+","+finalAsteroid.y + "  "+i);
                   //if(otherAsteroids.get("" + i ).size() == 0)
                     // otherAsteroids.remove(""+i);
                    if (count == 200) {
                        done=true;

                        for (int j = 0; j < candidates.size(); j++) {
                            System.out.println("final asteroid: "+candidates.get(j).x+","+candidates.get(j).y);
                        }
                        //System.out.println("Final asteroid: "+finalAsteroid.x+","+finalAsteroid.y);
                        break;
                    }
                }
            }
        }






    }

    static float slope(Coordinates start, Coordinates end){
        if(end.x==start.x)
            return 9999999;
        float slope = (float)(end.y - start.y) / (float)(end.x - start.x);
        return slope;
    }

    static int direction(Coordinates start, Coordinates end){
        if(start.x<end.x)
            return 1;
        else if(start.x>end.x)
            return -1;
        else if(start.y>end.y)
            return -1;
        else if(start.y<end.y)
            return 1;
        else
            return 0;
    }

    static int angle(Coordinates start, Coordinates end) {

        int xDifference=end.x-start.x;
        int yDifference=end.y-start.y;
        if(xDifference==0 && yDifference==0)
            return 999999999;
        else if(xDifference >= 0 && yDifference <= 0) {   //sector 1
            if(slope(start,end) > 1 || slope(start,end) < -1 )
                return Math.abs((int)((1/slope(start,end))*450000));
            else
                return 900000 - Math.abs((int)((slope(start,end))*450000)) ;
        }
        else if(xDifference >= 0 && yDifference >= 0) {  //sector 2
            if (slope(start,end) > 1 || slope(start,end) < -1 )
                return 1800000 - Math.abs((int) ((1 / slope(start, end)) * 450000));
            else
                return 900000 + Math.abs((int) ((slope(start, end)) * 450000));
        }
        else if(xDifference <= 0 && yDifference <= 0) {  //sector 4
            if (slope(start,end) > 1 || slope(start,end) < -1 )
                return 3600000 - Math.abs((int) ((1 / slope(start, end)) * 450000));
            else
                return 2700000 + Math.abs((int) ((slope(start, end)) * 450000));
        }
        else {                                            //sector 3
            if (slope(start,end) > 1 || slope(start,end) < -1 )
                return 1800000 + Math.abs((int) ((1 / slope(start, end)) * 450000));
            else
                return 2700000 - Math.abs((int) ((slope(start, end)) * 450000));
        }
    }



}
