package com.oddsonlogic.coding.advent;

import java.util.Arrays;
import java.util.List;

public class Day5 {
    public static void main(String[] args) {
        //Day 2 data: String data = "1,82,26,3,1,1,2,3,1,3,4,3,1,5,0,3,2,10,1,19,2,9,19,23,2,13,23,27,1,6,27,31,2,6,31,35,2,13,35,39,1,39,10,43,2,43,13,47,1,9,47,51,1,51,13,55,1,55,13,59,2,59,13,63,1,63,6,67,2,6,67,71,1,5,71,75,2,6,75,79,1,5,79,83,2,83,6,87,1,5,87,91,1,6,91,95,2,95,6,99,1,5,99,103,1,6,103,107,1,107,2,111,1,111,5,0,99,2,14,0,0";
        String data = "3,225,1,225,6,6,1100,1,238,225,104,0,1101,78,5,225,1,166,139,224,101,-74,224,224,4,224,1002,223,8,223,1001,224,6,224,1,223,224,223,1002,136,18,224,101,-918,224,224,4,224,1002,223,8,223,101,2,224,224,1,224,223,223,1001,83,84,224,1001,224,-139,224,4,224,102,8,223,223,101,3,224,224,1,224,223,223,1102,55,20,225,1101,53,94,225,2,217,87,224,1001,224,-2120,224,4,224,1002,223,8,223,1001,224,1,224,1,224,223,223,102,37,14,224,101,-185,224,224,4,224,1002,223,8,223,1001,224,1,224,1,224,223,223,1101,8,51,225,1102,46,15,225,1102,88,87,224,1001,224,-7656,224,4,224,102,8,223,223,101,7,224,224,1,223,224,223,1101,29,28,225,1101,58,43,224,1001,224,-101,224,4,224,1002,223,8,223,1001,224,6,224,1,224,223,223,1101,93,54,225,101,40,191,224,1001,224,-133,224,4,224,102,8,223,223,101,3,224,224,1,223,224,223,1101,40,79,225,4,223,99,0,0,0,677,0,0,0,0,0,0,0,0,0,0,0,1105,0,99999,1105,227,247,1105,1,99999,1005,227,99999,1005,0,256,1105,1,99999,1106,227,99999,1106,0,265,1105,1,99999,1006,0,99999,1006,227,274,1105,1,99999,1105,1,280,1105,1,99999,1,225,225,225,1101,294,0,0,105,1,0,1105,1,99999,1106,0,300,1105,1,99999,1,225,225,225,1101,314,0,0,106,0,0,1105,1,99999,1008,226,677,224,1002,223,2,223,1005,224,329,1001,223,1,223,1107,226,677,224,1002,223,2,223,1005,224,344,1001,223,1,223,8,677,226,224,1002,223,2,223,1006,224,359,1001,223,1,223,1108,226,677,224,1002,223,2,223,1006,224,374,101,1,223,223,1007,677,677,224,102,2,223,223,1006,224,389,1001,223,1,223,8,226,677,224,102,2,223,223,1006,224,404,101,1,223,223,1007,226,226,224,1002,223,2,223,1006,224,419,101,1,223,223,107,677,226,224,1002,223,2,223,1006,224,434,1001,223,1,223,1007,226,677,224,102,2,223,223,1005,224,449,101,1,223,223,1107,226,226,224,1002,223,2,223,1005,224,464,1001,223,1,223,107,226,226,224,102,2,223,223,1006,224,479,101,1,223,223,108,226,226,224,1002,223,2,223,1006,224,494,101,1,223,223,107,677,677,224,102,2,223,223,1005,224,509,1001,223,1,223,1008,677,677,224,1002,223,2,223,1006,224,524,101,1,223,223,1107,677,226,224,102,2,223,223,1006,224,539,1001,223,1,223,108,677,226,224,102,2,223,223,1006,224,554,1001,223,1,223,1108,677,226,224,102,2,223,223,1005,224,569,1001,223,1,223,8,677,677,224,1002,223,2,223,1005,224,584,1001,223,1,223,7,677,677,224,1002,223,2,223,1005,224,599,101,1,223,223,1108,226,226,224,102,2,223,223,1006,224,614,101,1,223,223,1008,226,226,224,1002,223,2,223,1005,224,629,101,1,223,223,7,677,226,224,102,2,223,223,1006,224,644,1001,223,1,223,7,226,677,224,102,2,223,223,1005,224,659,101,1,223,223,108,677,677,224,1002,223,2,223,1006,224,674,101,1,223,223,4,223,99,226";
        //Part 1 input:  int input =1
        int input = 5;

        List<String> items = Arrays.asList(data.split(","));
        int position = 0;
        int op1, op2, op3, op4, value1, value2;
        op1 = Integer.parseInt(items.get(position));
        while (op1 != 99) {
            op2 = Integer.parseInt(items.get(position + 1));


            op3 = Integer.parseInt(items.get(position + 2));


            op4 = Integer.parseInt(items.get(position + 3));
            switch (op1) {
                case 1:
                    value1 = Integer.parseInt(items.get(op2));
                    value2 = Integer.parseInt(items.get(op3));
                    items.set(op4, "" + (value1 + value2));
                    position = position + 4;
                    break;
                case 2:
                    value1 = Integer.parseInt(items.get(op2));
                    value2 = Integer.parseInt(items.get(op3));
                    items.set(op4, "" + (value1 * value2));
                    position = position + 4;
                    break;
                case 3:
                    items.set(op2, "" + input);
                    position = position + 2;
                    break;
                case 4:
                    System.out.println("Output: " + items.get(op2));
                    position = position + 2;
                    break;
                case 5:
                    value1 = Integer.parseInt(items.get(op2));
                    if(value1 != 0)
                        position = op3;
                    else
                        position = position + 3;
                    break;
                case 6:
                    value1 = Integer.parseInt(items.get(op2));
                    if(value1 == 0)
                        position = op3;
                    else
                        position = position + 3;
                    break;
                case 7:
                    value1 = Integer.parseInt(items.get(op2));
                    value2 = Integer.parseInt(items.get(op3));
                    if(value1 < value2)
                        items.set(op4,"1");
                    else
                        items.set(op4,"0");
                    position = position + 4;
                    break;
                case 8:
                    value1 = Integer.parseInt(items.get(op2));
                    value2 = Integer.parseInt(items.get(op3));
                    if(value1 == value2)
                        items.set(op4,"1");
                    else
                        items.set(op4,"0");
                    position = position + 4;
                    break;
                default:
                    int newOp1 = op1 % 10;
                    op1 = op1 / 100;
                    if(op1 % 10 == 0)
                        value1 = Integer.parseInt(items.get(op2));
                    else
                        value1 = op2;
                    op1 = op1 / 10;
                    if(op1 % 10 == 0) {
                        if (newOp1 <= 2 || newOp1 >=5)
                            value2 = Integer.parseInt(items.get(op3));
                        else
                            value2 = op3;
                    }
                    else
                        value2 = op3;

                    switch (newOp1) {
                        case 1:
                            items.set(op4, "" + (value1 + value2));
                            position = position + 4;
                            break;
                        case 2:
                            items.set(op4, "" + (value1 * value2));
                            position = position + 4;
                            break;
                        case 3:
                            items.set(op2, "" + input);
                            position = position + 2;
                            break;
                        case 4:
                            System.out.println("Output: " + items.get(op2));
                            position = position + 2;
                            break;
                        case 5:
                            if(value1 != 0)
                                position = value2;
                            else
                                position = position + 3;
                            break;
                        case 6:
                            if(value1 == 0)
                                position = value2;
                            else
                                position = position + 3;
                            break;
                        case 7:
                            if(value1 < value2)
                                items.set(op4,"1");
                            else
                                items.set(op4,"0");
                            position = position + 4;
                            break;

                        case 8:
                            if(value1 == value2)
                                items.set(op4,"1");
                            else
                                items.set(op4,"0");
                            position = position + 4;
                            break;
                        default:
                            break;
                    }

                    break;
            }

            op1 = Integer.parseInt(items.get(position));
        }
        System.out.println(items);
    }
}
