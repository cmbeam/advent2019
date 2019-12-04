package com.oddsonlogic.coding.advent;

public class Day4 {
    public static void main(String[] args) {
        int rangeStart = 168630;
        int rangeEnd = 718098;
        //int rangeStart = 111100;
        //int rangeEnd = 123450;


        int count1 = 0;
        int count2 = 0;

        for (int i = rangeStart; i <= rangeEnd ; i++) {
            String combination = ""+i;

            System.out.print("Possible: "+ combination + " ");
            boolean decValid = true;
            //Check for decreasing digits
            for (int j = 0; j < 5 ; j++) {
                if(combination.charAt(j) > combination.charAt(j+1))
                    decValid = false;
            }

            boolean adjValid = false;
            //Check for duplicate adjacent
            for (int j = 0; j < 5 ; j++) {
                if(combination.charAt(j) == combination.charAt(j+1))
                    adjValid = true;
            }

            boolean adj2Valid = false;
            //Check for duplicate adjacent
            for (int j = 0; j < 5 ; j++) {
                if(combination.charAt(j) == combination.charAt(j+1))
                    if((j==0 || (j>=1 && combination.charAt(j-1) != combination.charAt(j))) && (j==4 || (j<=3 && combination.charAt(j+1) != combination.charAt(j+2))) )
                        adj2Valid = true;
            }



            if(decValid && adjValid) {
                System.out.print("MATCH1 ");

                count1++;
            }

            if(decValid && adj2Valid) {
                System.out.print("MATCH2");

                count2++;
            }

            System.out.println();

        }

        System.out.println("Count part1: " + count1);
        System.out.println("Count part2: " + count2);
    }
}
