package com.oddsonlogic.coding.advent;

import java.util.*;

public class Day20 {


    HashMap<String, String> portals;
    List<String> path;
    int height = 0;
    int width = 0;
    Coordinates start = new Coordinates();
    Coordinates end = new Coordinates();

    public static void main(String[] args) {
        String input = "                                               G       D   M     A N       V           L                                             \n" +
                "                                               G       K   A     A Q       R           L                                             \n" +
                "  #############################################.#######.###.#####.#.#######.###########.###########################################  \n" +
                "  #.......#.........#.#...#.....#.....#.#.#...#.#...#.....#.......#.#.....#...#...#.......#.....#.....#.#.#...#.....#...#.#...#.#.#  \n" +
                "  #######.###.#.#.###.###.#####.###.###.#.#.#.#.#.#.#.###.#.#####.#.#.#.###.#.###.#.#######.#######.###.#.#.###.#####.###.#.###.#.#  \n" +
                "  #...........#.#...................#.....#.#.#...#.#.#...#.#.#...#...#...#.#...#...#...#.........#...........#...#.#.........#...#  \n" +
                "  ###.#.#.#####.###.#####.###.#.###.###.###.#.#.#####.###.#.#.#.#####.###.#.#######.#.###.#########.###.#.#######.#.###.#########.#  \n" +
                "  #...#.#.#...#.#.....#.....#.#.#.#.........#...#.#...#...#...#.#.#...#...#.......#.#.................#.#...#.......#...#.#.#.#...#  \n" +
                "  ###.#####.#####.#######.###.###.###.#####.#.#.#.#######.#.#####.#######.#.#######.#.###.#########.###.#.###.#.#.#####.#.#.#.#.#.#  \n" +
                "  #.......#.........#.....#.....#.....#.....#.#.....#.....#.#.....#...#...#.....#.......#.........#...#.#.#.#.#.#.#.#...#...#...#.#  \n" +
                "  #.#.#########.#.#####.#.###.#.#.###.#####.#.###.#######.#.###.###.#.###.#.#######.###.###################.###.###.#.###.#.#.#####  \n" +
                "  #.#.#.......#.#.#...#.#...#.#.#.#.#...#...#.#.....#.#...#.....#.#.#.....#...#...#...#.#...#.#...#.#...#...#.#...#...#.#.#.#.....#  \n" +
                "  #######.###########.###.#.#.#####.#####.#.###.#####.###.#.#####.###.###.#.#####.#.#####.#.#.#.###.#.#####.#.#.###.###.#.#.#.###.#  \n" +
                "  #.....#.................#.#.#.#.........#...#.#.........#...#.......#...#.#...#.........#.#...#.#...........#...#...#...#.#...#.#  \n" +
                "  ###.#.#######.###.#####.#####.###.###.###.#.#######.#.#.#.#######.###.###.#.###.#.###.#####.###.#.###########.###.#####.###.#####  \n" +
                "  #...#.#...#...#...#.......#...#.#.#.#.#.#.#.....#...#.#.#...#...#.#.#.#...#...#.#.#.#.#.......#.............#.#.....#.....#...#.#  \n" +
                "  #.#######.#######.#####.#####.#.###.###.#.#############.###.#.###.#.#####.#.#####.#.#.#####.###.#.###.###.###.#.#####.#.###.###.#  \n" +
                "  #...#.#...#.#.......#...#.#.#...........#...#...#.......#.#.#.......#.#.....#...#...#.#.....#...#.#.....#.....#.....#.#...#.#...#  \n" +
                "  #.###.###.#.#############.#.#.#.#####.#.#.###.#.#####.#.#.#.#####.###.#####.#.###.#####.#######.###############.#########.#.#.###  \n" +
                "  #...#.#.....#...#.#...#.....#.#.#...#.#.......#.#.#.#.#.#.....#.......#.....#.#.#...#...#.#.#.#.....#.#.#.........#.#.....#...#.#  \n" +
                "  #.###.#.#.###.###.###.#.###.#####.#######.#######.#.#.#.###.#####.###.###.###.#.#.###.###.#.#.#.###.#.#.#####.#.###.###.#.#.###.#  \n" +
                "  #...#...#...#.#.#.....#.#.........................#...#...#.#.#...#.#.#.#.#.#.........#...........#.#.#.#...#.#.#.....#.#...#.#.#  \n" +
                "  #.###.#######.#.#.###.###########.###.###.#####.#.###.#.###.#.###.#.###.#.#.#####.#.#.###.#####.#####.#.###.###.#.#######.#.#.#.#  \n" +
                "  #...#...#.#.....#.#.....#...#...#.#.....#.#.#...#...#.#.#.#...#.#.....#.....#.#.#.#.#.........#.........#...#.....#.....#.#...#.#  \n" +
                "  #.#####.#.###.#######.###.#####.#########.#.#.#.#######.#.###.#.#.###.#.#.###.#.#######.###################.#.#.#####.#####.###.#  \n" +
                "  #.........#.#.#...#.....#.#.#...#.#...#.#.#...#...#.#.#.#...#...#...#.#.#...#...#...#.........#.......#.#...#.#...#.#...#.#.#...#  \n" +
                "  #.###.###.#.#.#.###.###.#.#.###.#.###.#.###.#.#####.#.#.#.#.###.#.#########.#.#.#.###.#######.#####.###.###.###.###.#.###.#.###.#  \n" +
                "  #.#...#.#.....#...#.#...#.............#...#.#.#...#.....#.#.....#.#.#.....#...#...#.....#...#...#...#.#.#.....#...#.#.....#.....#  \n" +
                "  #######.###.###.#######.###.#.#.#.#.#.#.###.###.#####.###.#######.###.#.#######.###.#####.###.#####.#.#.#.#####.###.###.#####.#.#  \n" +
                "  #.......#...#.#.#...#.#...#.#.#.#.#.#.............#.#...#.......#...#.#.#...#...#...#.....#.#.#.....#.#.#...#...#.#.#.#.#.#.#.#.#  \n" +
                "  ###.#####.#.#.#.#.###.#.#######.#.###.#.#.###.#####.###.###.#######.#.#.#.#.#.###.###.#.#.#.#######.#.#.#.#####.#.#.#.#.#.#.#.###  \n" +
                "  #.....#.#.#.......#.#.#.#...#...#.#...#.#.#.#...#.......#.#...#.#...#.#.#.#.#...#.#...#.#...#.#.#.....#.#.#.#.....#...#.#.....#.#  \n" +
                "  ###.###.#####.###.#.#.#.#.###.#.#.#.#.#.#.#.#.###.#####.#.#.###.###.#.#.#.#.###.#.###.#.#.#.#.#.###.###.#.#.#####.###.#.###.###.#  \n" +
                "  #.....#.#.#.....#.#...#.#...#.#.#.#.#.#.#.#.....#...#.....#.#.....#...#.#.#.....#.....#.#.#.#.........#...#.#.......#.....#.....#  \n" +
                "  ###.###.#.#.#########.#.###.#######.#.#.#####.###.#####.###.###.#######.#.#############.#########.#.#####.#.#.#######.#####.#####  \n" +
                "  #.#.#.#.#.......#...#.....#.....#.#.#.#.#.......#.....#...#.....#.......#.....#...............#.#.#.#...#.....#.#.#...#.........#  \n" +
                "  #.#.#.#.###.#######.#.#.###.###.#.#############.#####.#########.#.###########.#####.###########.###.#.###.#####.#.###.#####.#.###  \n" +
                "  #...#...#.....#...#.#.#.#.#...#.#.#            J     N         G T           D     K          #.....#.#.#...#.#.#.#.....#...#.#.#  \n" +
                "  ###.#.###.#.###.###.###.#.#.#.###.#            Q     Y         Z O           K     P          #.###.#.#.###.#.#.#.###.#####.###.#  \n" +
                "  #...#...#.#.....#...#.#...#.#.#...#                                                           #.#.....#.#.......#.........#.....#  \n" +
                "  #.#.#.#######.###.###.#.#.###.#.###                                                           #####.#.#.###.###.#.###.###.#.###.#  \n" +
                "  #.#.#...#...#.#.#.#...#.#...#.....#                                                           #.....#.#...#...#.....#.#.#.#.#...#  \n" +
                "  #.###.#####.#.#.#.###.###.#####.###                                                           ###.#.#.#.#####.#.#######.#.#.#.###  \n" +
                "  #.#.#...#.#.#.#.#...#.#.....#...#.#                                                         GG..#.#.#.......#.#...#...#...#.#....HQ\n" +
                "  #.#.#.###.#.#.#.#.#.#.###.#.#.#.#.#                                                           #.#.#######.###.#.#####.#.###.#####  \n" +
                "  #...#...#.#.....#.#.#...#.#...#...#                                                           #...#.....#.....#.#...#.......#.#.#  \n" +
                "  #.#####.#.###.#####.###.#.#.###.#.#                                                           #######.#.#########.###########.#.#  \n" +
                "DR..#...........#...#.#.#.#.#.#...#.#                                                           #.......#.#.#...#...#.....#........IN\n" +
                "  #.###.###.###.###.#.#.#.#.#######.#                                                           #.###.#####.#.#.#.#.###.#.#.#.#.###  \n" +
                "  #.......#.#...............#.#.#....JE                                                         #.#.....#.....#...#.....#...#.#...#  \n" +
                "  #####.#.#####.#.###.#######.#.###.#                                                           #.#.#########.#.#####.###.#.#######  \n" +
                "  #.....#...#...#.#...#...#.....#.#.#                                                         JT..#.#...#.#...#.....#...#.#.....#.#  \n" +
                "  #####.###########.###.#.#.###.#.###                                                           ###.#.#.#.#.#.#.#.#####.#.###.###.#  \n" +
                "GZ....#...#.#.#.#.#.#.#.#...#.....#.#                                                           #.#...#.....#.#.#.#.#.#.#.#...#...#  \n" +
                "  #.#######.#.#.#.###.###.###.#####.#                                                           #.###############.#.#.###########.#  \n" +
                "  #.#.#.#.......#.....#...#...#...#..BI                                                         #...........#...#.#...#.#..........ZZ\n" +
                "  #.#.#.#####.#.###.#.#.###.###.#.#.#                                                           ###.#######.#.#######.#.###.#.###.#  \n" +
                "  #...........#.....#.....#.....#...#                                                           #.......#.....#...#.......#.#.#...#  \n" +
                "  #.###.###.#######.#######.#########                                                           #.###.#####.#####.###.###########.#  \n" +
                "  #...#.#...#.#.#...#.#.#...#.......#                                                         QX..#.......#.......#.#.#.....#...#.#  \n" +
                "  #.###.#####.#.#####.#.#.#.#####.#.#                                                           #.###.###.###.#####.#.#.#######.#.#  \n" +
                "  #...#.#...#.#.#...#...#.#.#...#.#..QP                                                         #.#.#...#.#........................CL\n" +
                "  #########.#.#.###.#.#.#.###.###.#.#                                                           ###.###.###########################  \n" +
                "  #...#.#.........#...#.#.#.#...#.#.#                                                         DR..#...#.#...#.#.....#.......#...#.#  \n" +
                "  #.###.###.#.#####.#.#.###.#.#.#.###                                                           #.#.#####.###.###.#.#.#.###.#.#.#.#  \n" +
                "BI..........#.......#.#.......#.....#                                                           #.....#...#.......#...#.#.....#....TO\n" +
                "  ###################################                                                           ###.#####.#.#.#.#.###.#####.#.#.###  \n" +
                "  #.....#...............#...........#                                                           #...#.#.....#.#.#...#...#.#.#.#...#  \n" +
                "  ###.#.#.#######.#.###.#.#####.###.#                                                           #.###.#####.#############.#.###.#.#  \n" +
                "  #...#.#.......#.#.#.......#...#.#.#                                                           #...........#...#.#.....#.#.#...#.#  \n" +
                "  ###.#.###.#####.#.#####.#.#####.#.#                                                           #.#.#########.###.#####.#.#########  \n" +
                "RG..#.#...#...#.#.#.#.#...#.#...#....VE                                                         #.#.#.#...#...#.#...........#......JQ\n" +
                "  #.#.#.###.#.#.#####.###.#####.#.###                                                           #####.#.#.#.#.#.###.#.###.#.#.#####  \n" +
                "  #...#.....#...#.#.#.#.#.#.#.#.#.#.#                                                         VR......#.#...#.......#.#...#...#...#  \n" +
                "  ###.#.###.#.###.#.#.#.###.#.#.###.#                                                           #####.#.###.###.###.#####.#.#.#.###  \n" +
                "  #.#.#.#.#.#.#.........#............NQ                                                         #.....#.#...#...#.....#.#.#.#.#...#  \n" +
                "  #.#####.#.#########.#.#.#.###.###.#                                                           ###.###.###.###.#######.###.###.###  \n" +
                "QX....#.........#...#.#...#.#.....#.#                                                           #.........#...#.#.#.#...#.#.#.#...#  \n" +
                "  #.#####.#########.#.#########.#####                                                           ###.###.###.###.#.#.###.#.###.#.###  \n" +
                "  #...#...#.....#...#.......#...#.#.#                                                         HQ..#.#...#.#.#.......#.........#...#  \n" +
                "  #.#########.#.#.#.#####.#######.#.#                                                           #.#######.#####.#.#####.#####.#.#.#  \n" +
                "  #...........#...#...........#...#.#                                                           #.#.....#...#...#.#.....#.#.....#.#  \n" +
                "  ###################.#####.#.###.#.#                                                           #.#.#.###.#############.#####.###.#  \n" +
                "JE..#.#...#.......#.#.#...#.#.#.....#                                                           #...#.#.....#...#...#.#...#...#....YN\n" +
                "  #.#.#.#.#.#####.#.#.###.###.#.#.###                                                           #####.#.#.#.#.#####.#.###.#######.#  \n" +
                "  #.#...#.#.#.....#.#.#.#...#.#.#...#                                                           #.#.#...#.#...............#...#...#  \n" +
                "  #.#.#.###.#.#####.###.###.###.#.###                                                           #.#.#.#######.###.#.#.#.#.###.###.#  \n" +
                "  #.#.#...#.#.........#...#.#...#...#                                                         IN..#.....#.#.....#.#.#.#.#.#.#.#...#  \n" +
                "  #.#.#.#.#.#.#######.#.###.###.#.#.#                                                           #.###.###.###.#######.#.###.#.#####  \n" +
                "  #...#.#...#...#...............#.#..YN                                                         #...#.#.#.#...#.....#.#.#...#.#...#  \n" +
                "  ###.###.#.#.#####.###.###.#######.#                                                           #.#####.#.#####.###########.#.###.#  \n" +
                "  #...#...#.#...#.#.#...#...#...#...#                                                           #...#.#.#.#.....#.#.....#...#......QY\n" +
                "  #.#.###.#######.###.#########.#.#.#                                                           ###.#.#.#.#.###.#.#####.#.#.#.###.#  \n" +
                "  #.#.#.........#.........#.#.....#.#                                                           #...........#.#...........#.....#.#  \n" +
                "  #####.#.#######.###.#.#.#.###.###.#        C     A     M           I       L Q R       I      ###.#######.#.#.#.###.#.#.#####.###  \n" +
                "  #.....#.#.......#...#.#.#.......#.#        L     F     A           T       L Y G       K      #...#.........#.#.#.#.#.#...#.#...#  \n" +
                "  #####.#.###.#.###.###.#.###.#.#############.#####.#####.###########.#######.#.#.#######.#######.#.#####.#####.#.#.#.###.###.#.#.#  \n" +
                "  #.....#...#.#.#...#...#.#...#.#.#.............#...#...#...#...#...#...#...#.#.#.....#.......#...#.#.......#.#.#...#.#.#...#.#.#.#  \n" +
                "  #.###.###.###.#######.#####.###.#.#.#.#.###.#####.###.#.#####.#.###.###.###.#.#.###.#######.#####.###.#####.#.###.###.#.###.#.###  \n" +
                "  #.#.....#.#...#...........#.#.....#.#.#...#.#...#...#.....#.....#.....#.....#...#...#...........#.#...#.........#.#.#.#.....#...#  \n" +
                "  #.###.###.#######.###.#.#####.#.#.#.#.#######.#.###.#.#######.###.#####.#.#.#####.#.#####.###.#######.###.###.#####.#.#.#.#.###.#  \n" +
                "  #.#.#.#.......#...#...#...#...#.#.#.#...#...#.#...#.#...#.#.#.......#.#.#.#...#.#.#.#.#.#...#.#...#.#...#...#.....#.....#.#...#.#  \n" +
                "  #.#.#.#####.#####.#####.#.#####.#####.#####.#.###.#.###.#.#.#####.###.#####.###.#.###.#.###.#####.#.#.###.#.#.###.#.#.#####.###.#  \n" +
                "  #.#...#.#...#.......#...#...#...#.......#...#...#...#.#...#...#.......#.....#.......#.............#.....#.#.#.#...#.#.#.#.#...#.#  \n" +
                "  ###.#.#.###.#.#.#####.#.#.#####.###.###.#.#.###.#.#.#.#.###.###.#.#######.#####.#####.#.#######.#.#.#.#.#####.#.###.#.#.#.#.#####  \n" +
                "  #...#.#.....#.#.#...#.#.#.#.#.#.#...#.#...#...#.#.#.#.......#.#.#...#...#...#.#...#...#.#...#...#.#.#.#...#.#.#.#...#.#.........#  \n" +
                "  #.#####.###########.###.###.#.###.#.#.###.#.###.#####.#.###.#.#####.###.#.#.#.#.#####.###.#.###.#####.#####.#.###.###.#.###.#####  \n" +
                "  #.....#.#.#.#...........#...#.#...#...#.#.#.#.......#.#.#.#.#.......#...#.#.#.....#.#.....#...#.....#.......#.#.#.#.#.#.#.......#  \n" +
                "  #.#######.#.#######.#######.#.#####.###.###.#.###########.#.#.#####.#.#.###.###.###.#.###.#.#.#########.#####.#.###.###.###.###.#  \n" +
                "  #.......#.....#.......#.........#.....#.#...#.#.#.#.....#...#.#...#.#.#...#.#.......#.#.#.#.#.......#.#.#.#.........#.....#...#.#  \n" +
                "  #.#########.###.#.#######.#####.###.###.###.#.#.#.###.#####.#.#.#.###.###.#.#####.#.###.###.#####.###.###.###.###.#####.###.###.#  \n" +
                "  #...#.....#...#.#.#.#.#.#.#.#...#.#.#.....#.#.....#.....#...#...#...#.#.......#...#.#.#.#.......#.......#.....#.....#...#.....#.#  \n" +
                "  #######.#####.#####.#.#.###.###.#.#####.###.#.#.#.#.#.#####.#####.#.#.###.#.#.#####.#.#.###.###.###.#.###.#.###.#########.#.###.#  \n" +
                "  #.........#.#.#.#...#.....#.#.#...#.......#.#.#.#...#...#.#.#.....#.#.#...#.#...#...#.....#...#.#...#...#.#.#.........#...#...#.#  \n" +
                "  ###.###.#.#.#.#.###.#.#####.#.#.#######.###.###.###.#.###.#.#####.#.#.#######.#####.###.###.#######.#.#.###.#.#.#.###.#####.#####  \n" +
                "  #...#...#.....................#.#.........#.#...#...#.#.....#.#...#.#...#.#...#.....#.......#.....#.#.#...#.#.#.#.#...#.#.#.#...#  \n" +
                "  #####.###.#.###.###.#########.#.#####.###.#.#####.#.#####.###.###.#.###.#.###.###.#.#.#####.#.#####.#######.#.#.#######.#.#.###.#  \n" +
                "  #.......#.#.#...#.....#.#.............#.#.......#.#.....#.#...#.#.#.#.......#.#...#.#.#...#.#.....#.......#.#.#.#...............#  \n" +
                "  #####.###.#####.#.#.###.###.#.#######.#.###########.#####.###.#.###.#.#.###.#######.#.###.#.#.###.###.#####.#######.#.#######.###  \n" +
                "  #.......#.#.....#.#.#.#...#.#.#.............#.#...#...#.#...#.......#.#.#.#.#.#...#.#.....#.....#.#...#.#.#.#.....#.#.#.......#.#  \n" +
                "  #####.#####.###.#####.###.#.#####.#######.###.#.###.###.###.###.#####.#.#.###.#.###.#.#####.#.###.#.###.#.###.###############.#.#  \n" +
                "  #.....#.#...#.....#.........#.#.#.#.......#.#.#.......#.......#.....#.#.#...........#.#.#...#...#.#...#.........#...............#  \n" +
                "  #.#####.#.###.#####.#.#######.#.#######.###.#.#####.###.#.#######.###.###.###.#######.#.###.###.#######.#.###.###.#.#.###.#.###.#  \n" +
                "  #.#.........#...#.#.#.#.............#.#...#.#.#...#.#...#.#.#.....#.#...#.#.........#...#.#.#.#.....#.#.#...#.#...#.#.#...#.#.#.#  \n" +
                "  ###.#####.###.###.#############.###.#.#.###.#.#.#.#.###.###.###.###.###.###.#.#.#.#.###.#.#.#.#######.###.#######.#.#.###.###.#.#  \n" +
                "  #...#.#...#.....#...#.............#.......#.....#.....#.......#...#...#...#.#.#.#.#.#.....#...#.....#.......#.#...#.#.#...#.....#  \n" +
                "  ###.#.#.###.#.#.###.#####.#.###.#####.#####.#.#############.###.#.#.###.###########.#.#######.###.###.#######.#######.###.#.###.#  \n" +
                "  #...#...#...#.#.#.......#.#...#.#.........#.#.......#...#.....#.#.....#...#.....#...#.......#.....................#.....#.#.#...#  \n" +
                "  #.#.###.#.###.#.#.###.#.#.#.###.#.#.#.#############.#.#.#.#####.#.#.###.#####.#####.###.#####.#####.#.###.###.#.#####.#####.###.#  \n" +
                "  #.#...#.#...#.#.#.#...#...#.#...#.#.#.....#.........#.#.....#...#.#...#.....#.......#...#.........#.#...#...#.#.....#.....#...#.#  \n" +
                "  #######################################.#######.#####.#############.#####.#######.#.###.#########################################  \n" +
                "                                         K       J     I             I     A       Q N   V                                           \n" +
                "                                         P       T     T             K     F       P Y   E                                           ";

        /*
        input = "         A           \n" +
                "         A           \n" +
                "  #######.#########  \n" +
                "  #######.........#  \n" +
                "  #######.#######.#  \n" +
                "  #######.#######.#  \n" +
                "  #######.#######.#  \n" +
                "  #####  B    ###.#  \n" +
                "BC...##  C    ###.#  \n" +
                "  ##.##       ###.#  \n" +
                "  ##...DE  F  ###.#  \n" +
                "  #####    G  ###.#  \n" +
                "  #########.#####.#  \n" +
                "DE..#######...###.#  \n" +
                "  #.#########.###.#  \n" +
                "FG..#########.....#  \n" +
                "  ###########.#####  \n" +
                "             Z       \n" +
                "             Z       ";

         */

         /*
        input = "                   A               \n" +
                "                   A               \n" +
                "  #################.#############  \n" +
                "  #.#...#...................#.#.#  \n" +
                "  #.#.#.###.###.###.#########.#.#  \n" +
                "  #.#.#.......#...#.....#.#.#...#  \n" +
                "  #.#########.###.#####.#.#.###.#  \n" +
                "  #.............#.#.....#.......#  \n" +
                "  ###.###########.###.#####.#.#.#  \n" +
                "  #.....#        A   C    #.#.#.#  \n" +
                "  #######        S   P    #####.#  \n" +
                "  #.#...#                 #......VT\n" +
                "  #.#.#.#                 #.#####  \n" +
                "  #...#.#               YN....#.#  \n" +
                "  #.###.#                 #####.#  \n" +
                "DI....#.#                 #.....#  \n" +
                "  #####.#                 #.###.#  \n" +
                "ZZ......#               QG....#..AS\n" +
                "  ###.###                 #######  \n" +
                "JO..#.#.#                 #.....#  \n" +
                "  #.#.#.#                 ###.#.#  \n" +
                "  #...#..DI             BU....#..LF\n" +
                "  #####.#                 #.#####  \n" +
                "YN......#               VT..#....QG\n" +
                "  #.###.#                 #.###.#  \n" +
                "  #.#...#                 #.....#  \n" +
                "  ###.###    J L     J    #.#.###  \n" +
                "  #.....#    O F     P    #.#...#  \n" +
                "  #.###.#####.#.#####.#####.###.#  \n" +
                "  #...#.#.#...#.....#.....#.#...#  \n" +
                "  #.#####.###.###.#.#.#########.#  \n" +
                "  #...#.#.....#...#.#.#.#.....#.#  \n" +
                "  #.###.#####.###.###.#.#.#######  \n" +
                "  #.#.........#...#.............#  \n" +
                "  #########.###.###.#############  \n" +
                "           B   J   C               \n" +
                "           U   P   P               ";

          */
/*
         input="             Z L X W       C                 \n" +
                 "             Z P Q B       K                 \n" +
                 "  ###########.#.#.#.#######.###############  \n" +
                 "  #...#.......#.#.......#.#.......#.#.#...#  \n" +
                 "  ###.#.#.#.#.#.#.#.###.#.#.#######.#.#.###  \n" +
                 "  #.#...#.#.#...#.#.#...#...#...#.#.......#  \n" +
                 "  #.###.#######.###.###.#.###.###.#.#######  \n" +
                 "  #...#.......#.#...#...#.............#...#  \n" +
                 "  #.#########.#######.#.#######.#######.###  \n" +
                 "  #...#.#    F       R I       Z    #.#.#.#  \n" +
                 "  #.###.#    D       E C       H    #.#.#.#  \n" +
                 "  #.#...#                           #...#.#  \n" +
                 "  #.###.#                           #.###.#  \n" +
                 "  #.#....OA                       WB..#.#..ZH\n" +
                 "  #.###.#                           #.#.#.#  \n" +
                 "CJ......#                           #.....#  \n" +
                 "  #######                           #######  \n" +
                 "  #.#....CK                         #......IC\n" +
                 "  #.###.#                           #.###.#  \n" +
                 "  #.....#                           #...#.#  \n" +
                 "  ###.###                           #.#.#.#  \n" +
                 "XF....#.#                         RF..#.#.#  \n" +
                 "  #####.#                           #######  \n" +
                 "  #......CJ                       NM..#...#  \n" +
                 "  ###.#.#                           #.###.#  \n" +
                 "RE....#.#                           #......RF\n" +
                 "  ###.###        X   X       L      #.#.#.#  \n" +
                 "  #.....#        F   Q       P      #.#.#.#  \n" +
                 "  ###.###########.###.#######.#########.###  \n" +
                 "  #.....#...#.....#.......#...#.....#.#...#  \n" +
                 "  #####.#.###.#######.#######.###.###.#.#.#  \n" +
                 "  #.......#.......#.#.#.#.#...#...#...#.#.#  \n" +
                 "  #####.###.#####.#.#.#.#.###.###.#.###.###  \n" +
                 "  #.......#.....#.#...#...............#...#  \n" +
                 "  #############.#.#.###.###################  \n" +
                 "               A O F   N                     \n" +
                 "               A A D   M                     ";


 */
        List<String> items = Arrays.asList(input.split("\n"));
        Day20 day20 = new Day20();
        day20.portals = new HashMap<String, String>();
        day20.path = new ArrayList<>();
        day20.height = items.size();
        day20.width = items.get(0).length();
        System.out.println("width: " + day20.width + " Height: " + day20.height);

        //Parse maze
        int y = day20.height - 1;
        for (String item : items) {
            for (int x = 0; x < day20.width; x++) {
                Coordinates coordinate = new Coordinates();
                coordinate.x = x;
                coordinate.y = y;
                char waypoint = item.charAt(x);
                //upper case = portal
                if (Character.isUpperCase(waypoint))
                    day20.portals.put(coordinate.toString(), "" + waypoint);
                    //. path
                else if (waypoint == '.')
                    day20.path.add(coordinate.toString());
                //# = wall
                //else if(waypoint=='#')

            }
            y--;
        }
        //Refactor the portal identifiers
        HashMap<String, String> portalMap = new HashMap<>(day20.portals);
        for (Map.Entry<String, String> portal : portalMap.entrySet()) {
            Coordinates point = new Coordinates(Coordinates.stringValue(portal.getKey()));
            if (day20.path.contains(Coordinates.up(point).toString())) {
                day20.path.remove(Coordinates.up(point).toString());

                day20.portals.put(Coordinates.up(point).toString(),
                        day20.portals.get(point.toString()) + day20.portals.get(Coordinates.down(point).toString()));

                day20.portals.remove(point.toString());
                day20.portals.remove(Coordinates.down(point).toString());
            } else if (day20.path.contains(Coordinates.down(point).toString())) {
                day20.path.remove(Coordinates.down(point).toString());

                day20.portals.put(Coordinates.down(point).toString(),
                        day20.portals.get(Coordinates.up(point).toString()) + day20.portals.get(point.toString()));

                day20.portals.remove(point.toString());
                day20.portals.remove(Coordinates.up(point).toString());
            } else if (day20.path.contains(Coordinates.left(point).toString())) {
                day20.path.remove(Coordinates.left(point).toString());
                day20.portals.put(Coordinates.left(point).toString(),

                        day20.portals.get(point.toString()) + day20.portals.get(Coordinates.right(point).toString()));

                day20.portals.remove(point.toString());
                day20.portals.remove(Coordinates.right(point).toString());
            } else if (day20.path.contains(Coordinates.right(point).toString())) {
                day20.path.remove(Coordinates.right(point).toString());

                day20.portals.put(Coordinates.right(point).toString(),
                        day20.portals.get(Coordinates.left(point).toString()) + day20.portals.get(point.toString()));

                day20.portals.remove(point.toString());
                day20.portals.remove(Coordinates.left(point).toString());
            }

        }
        day20.start = day20.getCoordinates("AA");
        day20.end = day20.getCoordinates("ZZ");


        day20.printMaze();
        System.out.println();

        //TEST: Manualy set end point to something easy
        //day20.end.y = day20.start.y + 3;
        //day20.end.x = day20.start.x;


        int path = day20.findShortestPathWithPortals(day20.start, day20.end);

        System.out.println("path length: " + path);


    }


    public void printMaze() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                Coordinates coordinate = new Coordinates();
                coordinate.x = j;
                coordinate.y = i;
                if (path.contains(coordinate.toString()))
                    System.out.print(".");
                else if (portals.containsKey(coordinate.toString()))
                    System.out.print("P");
                else if (coordinate.x == start.x && coordinate.y == start.y)
                    System.out.print("S");
                else if (coordinate.x == end.x && coordinate.y == end.y)
                    System.out.print("E");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    static class Point {
        int x;
        int y;
        int level;

        public Point(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;

        }
    }

    ;

    static class QueueNode {
        Day20.Point pt; // The cordinates of a cell
        int dist; // cell's distance of from the source


        public QueueNode(Day20.Point pt, int dist) {
            this.pt = pt;
            this.dist = dist;
        }
    }

    ;

    public boolean isEmpty(Coordinates endpoint) {
        if (path.contains(endpoint.toString()))
            return true;
        else if (portals.containsKey((endpoint.toString())))
            return true;
        else
            return false;


    }

    static boolean isValid(int row, int col, int rowMax, int colMax) {
        // return true if row number and
        // column number is in range
        return (row >= 0) && (row < rowMax) &&
                (col >= 0) && (col < colMax);
    }

    static int rowNum[] = {1, -1, 0, 0};
    static int colNum[] = {0, 0, -1, 1};

    public int findShortestPathWithPortals(Coordinates startPoint, Coordinates endPoint) {

        boolean[][][] visited = new boolean[width][height][1000];

        // Mark the source cell as visited
        visited[startPoint.x][startPoint.y][0] = true;


        Queue<Day20.QueueNode> queue = new LinkedList<>();

        // Distance of start point is 0
        Day20.QueueNode node = new Day20.QueueNode(new Day20.Point(startPoint.x, startPoint.y, 0), 0);
        queue.add(node); // Enqueue source cell
        while (!queue.isEmpty()) {
            Day20.QueueNode curr = queue.peek();
            Day20.Point pt = curr.pt;

            // If we have reached the destination cell,
            // we are done
            //if (pt.x == dest.x && pt.y == dest.y)
            //    return curr.dist;

            // Otherwise dequeue the front cell
            // in the queue and enqueue
            // its adjacent cells
            queue.remove();


            for (int i = 0; i < 4; i++) {
                int row = pt.y + rowNum[i];
                int col = pt.x + colNum[i];
                int level =pt.level;

                Coordinates currPoint = new Coordinates();
                currPoint.x = col;
                currPoint.y = row;
                currPoint.level = pt.level;
                // if adjacent cell is valid, has path
                // and not visited yet, enqueue it.

                if (isValid(row, col, height, width) && !visited[col][row][level] && endPoint.x == col && endPoint.y == row && pt.level == 0) {

                    return curr.dist + 1;
                }
                if (isValid(row, col, height, width) && !visited[col][row][level] && isEmpty(currPoint)) {
                    // mark cell as visited and enqueue it

                    visited[col][row][level] = true;
                    Day20.QueueNode adjcell = new Day20.QueueNode(new Day20.Point(col, row,level),
                            curr.dist + 1);

                    //if portal than warp to new coordinates
                    if (portals.containsKey(currPoint.toString())) {
                        col = portalWarp(currPoint).x;
                        row = portalWarp(currPoint).y;
                        level = portalWarp(currPoint).level;
                        adjcell = new Day20.QueueNode(new Day20.Point(col, row,level),
                                curr.dist + 2);
                    }

                    queue.add(adjcell);

                }

            }

        }

        // Return -1 if destination cannot be reached
        return -1;
    }

    public Coordinates portalWarp(Coordinates entry) {
        Coordinates exit = new Coordinates();
        if((entry.x == 2 || entry.x == (width-3) || entry.y == 2 || entry.y == (height-3))&&entry.level==0){
            return entry;
        }
        else if((entry.x == 2 || entry.x == (width-3) || entry.y == 2 || entry.y == (height-3))&&entry.level>0){
            exit.level = entry.level  - 1;
        }
        else {
            exit.level = entry.level + 1;
        }
        String portalName = portals.get(entry.toString());

        for (Map.Entry<String, String> portal : portals.entrySet()) {
            if (portal.getValue().equals(portalName) && !portal.getKey().equals(entry.toString())) {
                exit.y = Coordinates.stringValue(portal.getKey()).y;
                exit.x = Coordinates.stringValue(portal.getKey()).x;


            }
        }
        return exit;
    }

    public Coordinates getCoordinates(String portalName) {
        Coordinates point = new Coordinates();
        for (Map.Entry<String, String> portal : portals.entrySet()) {
            if (portal.getValue().equals(portalName)) {
                point.y = Coordinates.stringValue(portal.getKey()).y;
                point.x = Coordinates.stringValue(portal.getKey()).x;
            }
        }
        return point;
    }
}
