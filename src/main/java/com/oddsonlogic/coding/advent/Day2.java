package com.oddsonlogic.coding.advent;

import java.util.Arrays;
import java.util.List;

public class Day2 {
    public static void main(String[] args) {
        String data="1,82,26,3,1,1,2,3,1,3,4,3,1,5,0,3,2,10,1,19,2,9,19,23,2,13,23,27,1,6,27,31,2,6,31,35,2,13,35,39,1,39,10,43,2,43,13,47,1,9,47,51,1,51,13,55,1,55,13,59,2,59,13,63,1,63,6,67,2,6,67,71,1,5,71,75,2,6,75,79,1,5,79,83,2,83,6,87,1,5,87,91,1,6,91,95,2,95,6,99,1,5,99,103,1,6,103,107,1,107,2,111,1,111,5,0,99,2,14,0,0";

        List<String> items = Arrays.asList(data.split(","));
        int position = 0;
        int op1,op2,op3,op4,value1,value2;
        op1 = Integer.parseInt(items.get(position));
        while(op1 != 99) {
            op2 = Integer.parseInt(items.get(position+1));
            value1 = Integer.parseInt(items.get(op2));

            op3 = Integer.parseInt(items.get(position+2));
            value2 = Integer.parseInt(items.get(op3));

            op4 = Integer.parseInt(items.get(position+3));
            if(op1==1)
                items.set(op4,""+(value1+value2));
            else
                items.set(op4,""+(value1*value2));
            position = position + 4;
            op1 = Integer.parseInt(items.get(position));
        }
        System.out.println(items);
    }
}
