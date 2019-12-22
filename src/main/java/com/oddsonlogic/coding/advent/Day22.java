package com.oddsonlogic.coding.advent;

import java.util.Arrays;
import java.util.List;

public class Day22 {
    public static void main(String[] args) {
        String input = "cut 9002\n" +
                "deal with increment 17\n" +
                "cut -4844\n" +
                "deal with increment 26\n" +
                "cut -4847\n" +
                "deal with increment 74\n" +
                "deal into new stack\n" +
                "deal with increment 75\n" +
                "deal into new stack\n" +
                "deal with increment 64\n" +
                "cut 9628\n" +
                "deal with increment 41\n" +
                "cut 9626\n" +
                "deal with increment 40\n" +
                "cut -7273\n" +
                "deal into new stack\n" +
                "deal with increment 20\n" +
                "deal into new stack\n" +
                "cut 2146\n" +
                "deal with increment 7\n" +
                "cut -3541\n" +
                "deal with increment 25\n" +
                "cut -1343\n" +
                "deal with increment 42\n" +
                "cut -2608\n" +
                "deal with increment 75\n" +
                "cut -9258\n" +
                "deal into new stack\n" +
                "cut -2556\n" +
                "deal into new stack\n" +
                "cut -5363\n" +
                "deal into new stack\n" +
                "cut -8143\n" +
                "deal with increment 15\n" +
                "cut -9309\n" +
                "deal with increment 65\n" +
                "cut -5470\n" +
                "deal with increment 9\n" +
                "deal into new stack\n" +
                "deal with increment 64\n" +
                "cut 137\n" +
                "deal with increment 40\n" +
                "deal into new stack\n" +
                "cut 5042\n" +
                "deal with increment 74\n" +
                "cut 4021\n" +
                "deal with increment 39\n" +
                "cut -5108\n" +
                "deal with increment 50\n" +
                "cut -6608\n" +
                "deal with increment 64\n" +
                "cut 4438\n" +
                "deal with increment 48\n" +
                "cut 7916\n" +
                "deal with increment 23\n" +
                "cut -6677\n" +
                "deal with increment 27\n" +
                "cut -1758\n" +
                "deal with increment 32\n" +
                "cut -3104\n" +
                "deal with increment 37\n" +
                "cut 9453\n" +
                "deal with increment 20\n" +
                "deal into new stack\n" +
                "deal with increment 6\n" +
                "cut 8168\n" +
                "deal with increment 69\n" +
                "cut 6704\n" +
                "deal with increment 45\n" +
                "cut -9423\n" +
                "deal with increment 2\n" +
                "cut -3498\n" +
                "deal with increment 39\n" +
                "deal into new stack\n" +
                "cut 6051\n" +
                "deal with increment 42\n" +
                "cut 7140\n" +
                "deal into new stack\n" +
                "deal with increment 73\n" +
                "cut -8201\n" +
                "deal into new stack\n" +
                "deal with increment 13\n" +
                "cut 2737\n" +
                "deal with increment 3\n" +
                "cut -4651\n" +
                "deal into new stack\n" +
                "deal with increment 30\n" +
                "cut -1505\n" +
                "deal with increment 59\n" +
                "deal into new stack\n" +
                "deal with increment 55\n" +
                "cut 8899\n" +
                "deal with increment 39\n" +
                "cut 8775\n" +
                "deal with increment 57\n" +
                "cut -1919\n" +
                "deal with increment 39\n" +
                "cut -3845\n" +
                "deal with increment 8\n" +
                "cut -4202";

        SpaceCards deck = new SpaceCards(10007);

        List<String> instructions = Arrays.asList(input.split("\n"));
        for (String instruction: instructions) {
            if(instruction.equals("deal into new stack")){
                System.out.println("Deal Before: "+deck.toString());
                deck.dealIntoNewStack();
                System.out.println("Deal After: "+deck.toString());
            }
            if(instruction.contains("cut")){
                int n = Integer.parseInt(instruction.substring(4));
                System.out.println("cut "+n+" Before: "+deck.toString());
                deck.cut(n);
                System.out.println("cut "+n+"  After: "+deck.toString());
            }
            if(instruction.contains("deal with increment")){
                int n = Integer.parseInt(instruction.substring(20));
                System.out.println("deal increment "+n+" Before: "+deck.toString());
                deck.dealWithIncrement(n);
                System.out.println("deal increment "+n+"  After: "+deck.toString());
            }



        }
        System.out.println("Card 2019 position: "+deck.findPosition(2019));
        System.out.println("Card at 2020 position: "+deck.deck[2020]);

    }
}
