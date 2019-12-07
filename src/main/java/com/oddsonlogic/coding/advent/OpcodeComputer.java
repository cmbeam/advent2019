package com.oddsonlogic.coding.advent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpcodeComputer {
    static final String program = "3,8,1001,8,10,8,105,1,0,0,21,42,55,64,85,98,179,260,341,422,99999,3,9,101,2,9,9,102,5,9,9,1001,9,2,9,1002,9,5,9,4,9,99,3,9,1001,9,5,9,1002,9,4,9,4,9,99,3,9,101,3,9,9,4,9,99,3,9,1002,9,4,9,101,3,9,9,102,5,9,9,101,4,9,9,4,9,99,3,9,1002,9,3,9,1001,9,3,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,101,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,99,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,99,3,9,1001,9,1,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,99";

    int position=0;
    int output=0;
    boolean done = false;
    ArrayList<Integer> inputs = new ArrayList<>();

    public void reset(){
        this.position = 0;
        this.output = 0;
        this.done = false;
    }

    public int compute(){
        int inputCount = 0;
        List<String> items = Arrays.asList(program.split(","));
        int op1, op2, op3, op4, value1, value2;
        op1 = Integer.parseInt(items.get(position));

        while (op1 != 99) {
            op2 = Integer.parseInt(items.get(position + 1));


            op3 = Integer.parseInt(items.get(position + 2));

            try {
                op4 = Integer.parseInt(items.get(position + 3));
            } catch (Exception e){
                op4=0;
            }
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
                    items.set(op2, "" + inputs.get(0));
                    inputs.remove(0);
                    position = position + 2;
                    break;
                case 4:
                    output=Integer.parseInt(items.get(op2));
                    System.out.println("Output: " + items.get(op2));
                    position = position + 2;
                    return output;

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
                            items.set(op2, "" + inputs.get(0));
                            inputs.remove(0);
                            position = position + 2;
                            break;
                        case 4:
                            output=Integer.parseInt(items.get(op2));
                            System.out.println("Output: " + items.get(op2));
                            position = position + 2;
                            inputs.clear();
                            return output;

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
        this.done = true;
        return output;
    }
}
