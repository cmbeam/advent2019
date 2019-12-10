package com.oddsonlogic.coding.advent;

import java.util.ArrayList;
import java.util.Arrays;
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

        /*data=".#..#\n" +
                ".....\n" +
                "#####\n" +
                "....#\n" +
                "...##";*/

        List<Coordinates> asteroids = new ArrayList<>();
        int mostAsteroids = 0;

        List<String> dataArray = Arrays.asList(data.split("\n"));
        int y = dataArray.size() - 1;

        for (String line : dataArray) {
            for (int i = 0; i < line.length() ; i++) {
                if(line.charAt(i)=='#') {
                    Coordinates coord = new Coordinates();
                    coord.x = i;
                    coord.y = y;
                    asteroids.add(coord);
                }
            }
            y--;

        }

        for (Coordinates asteroid: asteroids) {
             System.out.println("x :  "+asteroid.x+"  y : "+asteroid.y);
            List<String> lineOfSight = new ArrayList<>();
            for (Coordinates candidateAsteroid: asteroids) {
                String vector = ""+slope(asteroid,candidateAsteroid)+" "+direction(asteroid,candidateAsteroid);
                System.out.println(vector);
                if(!lineOfSight.contains(vector))
                        lineOfSight.add(vector);
            }
            System.out.println("Line of sight number: "+lineOfSight.size());
            if(lineOfSight.size() >= mostAsteroids)
                mostAsteroids = lineOfSight.size();

        }

        System.out.println("Largest number: " + (mostAsteroids-1));




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



}
