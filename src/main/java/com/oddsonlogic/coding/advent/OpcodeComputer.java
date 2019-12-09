package com.oddsonlogic.coding.advent;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpcodeComputer {
    //day 7 static final String program = "3,8,1001,8,10,8,105,1,0,0,21,42,55,64,85,98,179,260,341,422,99999,3,9,101,2,9,9,102,5,9,9,1001,9,2,9,1002,9,5,9,4,9,99,3,9,1001,9,5,9,1002,9,4,9,4,9,99,3,9,101,3,9,9,4,9,99,3,9,1002,9,4,9,101,3,9,9,102,5,9,9,101,4,9,9,4,9,99,3,9,1002,9,3,9,1001,9,3,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,101,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,99,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,99,3,9,1001,9,1,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,99";

    static final String program ="1102,34463338,34463338,63,1007,63,34463338,63,1005,63,53,1101,3,0,1000,109,988,209,12,9,1000,209,6,209,3,203,0,1008,1000,1,63,1005,63,65,1008,1000,2,63,1005,63,904,1008,1000,0,63,1005,63,58,4,25,104,0,99,4,0,104,0,99,4,17,104,0,99,0,0,1102,1,31,1018,1102,352,1,1023,1101,0,1,1021,1101,0,33,1003,1102,1,36,1007,1102,21,1,1005,1101,359,0,1022,1101,0,787,1024,1102,1,24,1011,1101,30,0,1014,1101,22,0,1016,1101,0,0,1020,1102,1,29,1000,1101,778,0,1025,1102,23,1,1017,1102,1,28,1002,1101,38,0,1019,1102,1,27,1013,1102,1,32,1012,1101,0,37,1006,1101,444,0,1027,1102,1,20,1009,1101,0,447,1026,1101,0,39,1008,1101,35,0,1010,1102,559,1,1028,1102,26,1,1004,1102,1,25,1015,1102,1,34,1001,1101,0,554,1029,109,-3,2101,0,9,63,1008,63,34,63,1005,63,205,1001,64,1,64,1105,1,207,4,187,1002,64,2,64,109,23,21107,40,39,-7,1005,1013,227,1001,64,1,64,1106,0,229,4,213,1002,64,2,64,109,-17,1202,-2,1,63,1008,63,36,63,1005,63,249,1106,0,255,4,235,1001,64,1,64,1002,64,2,64,109,-6,1202,10,1,63,1008,63,36,63,1005,63,277,4,261,1106,0,281,1001,64,1,64,1002,64,2,64,109,-2,1208,9,26,63,1005,63,303,4,287,1001,64,1,64,1106,0,303,1002,64,2,64,109,32,1206,-7,321,4,309,1001,64,1,64,1106,0,321,1002,64,2,64,109,-29,1207,7,20,63,1005,63,337,1105,1,343,4,327,1001,64,1,64,1002,64,2,64,109,27,2105,1,-2,1001,64,1,64,1106,0,361,4,349,1002,64,2,64,109,-25,2108,39,7,63,1005,63,377,1106,0,383,4,367,1001,64,1,64,1002,64,2,64,109,1,1201,6,0,63,1008,63,36,63,1005,63,409,4,389,1001,64,1,64,1105,1,409,1002,64,2,64,109,1,2102,1,1,63,1008,63,33,63,1005,63,435,4,415,1001,64,1,64,1105,1,435,1002,64,2,64,109,28,2106,0,-3,1106,0,453,4,441,1001,64,1,64,1002,64,2,64,109,-13,21101,41,0,1,1008,1018,44,63,1005,63,477,1001,64,1,64,1106,0,479,4,459,1002,64,2,64,109,4,21108,42,42,-2,1005,1019,501,4,485,1001,64,1,64,1106,0,501,1002,64,2,64,109,-21,2101,0,2,63,1008,63,28,63,1005,63,523,4,507,1105,1,527,1001,64,1,64,1002,64,2,64,109,26,1205,-5,545,4,533,1001,64,1,64,1105,1,545,1002,64,2,64,109,3,2106,0,-1,4,551,1106,0,563,1001,64,1,64,1002,64,2,64,109,-33,1201,4,0,63,1008,63,28,63,1005,63,583,1105,1,589,4,569,1001,64,1,64,1002,64,2,64,109,11,2107,27,-3,63,1005,63,609,1001,64,1,64,1106,0,611,4,595,1002,64,2,64,109,8,21102,43,1,3,1008,1018,43,63,1005,63,637,4,617,1001,64,1,64,1105,1,637,1002,64,2,64,109,-5,21108,44,41,0,1005,1010,653,1105,1,659,4,643,1001,64,1,64,1002,64,2,64,109,-13,2108,21,8,63,1005,63,681,4,665,1001,64,1,64,1106,0,681,1002,64,2,64,109,6,1207,0,34,63,1005,63,703,4,687,1001,64,1,64,1105,1,703,1002,64,2,64,109,7,1208,-7,35,63,1005,63,723,1001,64,1,64,1106,0,725,4,709,1002,64,2,64,109,-13,2102,1,7,63,1008,63,23,63,1005,63,745,1105,1,751,4,731,1001,64,1,64,1002,64,2,64,109,13,1205,10,767,1001,64,1,64,1105,1,769,4,757,1002,64,2,64,109,14,2105,1,0,4,775,1001,64,1,64,1106,0,787,1002,64,2,64,109,-20,21107,45,46,7,1005,1011,809,4,793,1001,64,1,64,1105,1,809,1002,64,2,64,109,-3,2107,25,3,63,1005,63,827,4,815,1106,0,831,1001,64,1,64,1002,64,2,64,109,13,1206,7,847,1001,64,1,64,1106,0,849,4,837,1002,64,2,64,109,-11,21101,46,0,7,1008,1010,46,63,1005,63,871,4,855,1106,0,875,1001,64,1,64,1002,64,2,64,109,15,21102,47,1,-4,1008,1014,48,63,1005,63,895,1106,0,901,4,881,1001,64,1,64,4,64,99,21102,27,1,1,21101,0,915,0,1106,0,922,21201,1,63208,1,204,1,99,109,3,1207,-2,3,63,1005,63,964,21201,-2,-1,1,21102,1,942,0,1106,0,922,21202,1,1,-1,21201,-2,-3,1,21101,957,0,0,1105,1,922,22201,1,-1,-2,1106,0,968,21201,-2,0,-2,109,-3,2106,0,0";
 int extraMemory = 100000000;

    int position=0;
    int output=0;
    boolean done = false;
    ArrayList<Integer> inputs = new ArrayList<>();
    int relativeBase = 0;

    public void reset(){
        this.position = 0;
        this.output = 0;
        this.done = false;
    }

    public int compute(){
        int inputCount = 0;
        List<String> items = new ArrayList<>(Arrays.asList(program.split(",")));
        for (int i = 0; i <extraMemory ; i++) {
            items.add(items.size(),"0");
        }


        int op1, op2, op3, op4;
        BigInteger value1, value2;
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
                    value1 = new BigInteger(items.get(op2));
                    value2 = new BigInteger(items.get(op3));
                    items.set(op4, value1.add(value2).toString());
                    position = position + 4;
                    break;
                case 2:
                    value1 = new BigInteger(items.get(op2));
                    value2 = new BigInteger(items.get(op3));
                    items.set(op4, value1.multiply(value2).toString());
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
                    value1 = new BigInteger(items.get(op2));
                    if(!value1.equals(BigInteger.ZERO))
                        position = op3;
                    else
                        position = position + 3;
                    break;
                case 6:
                    value1 = new BigInteger(items.get(op2));
                    if(value1.equals(BigInteger.ZERO))
                        position = op3;
                    else
                        position = position + 3;
                    break;
                case 7:
                    value1 = new BigInteger(items.get(op2));
                    value2 = new BigInteger(items.get(op3));
                    //if(value1 < value2)
                    if(value1.compareTo(value2) < 0)
                        items.set(op4,"1");
                    else
                        items.set(op4,"0");
                    position = position + 4;
                    break;
                case 8:
                    value1 = new BigInteger(items.get(op2));
                    value2 = new BigInteger(items.get(op3));
                    if(value1.equals(value2))
                        items.set(op4,"1");
                    else
                        items.set(op4,"0");
                    position = position + 4;
                    break;
                case 9:
                    relativeBase = Integer.parseInt(items.get(op2));
                    position = position + 2;

                    break;
                default:
                    int newOp1 = op1 % 10;
                    op1 = op1 / 100;
                    if(op1 % 10 == 0)
                        value1 = new BigInteger(items.get(op2));
                    else if(op1 % 10 == 1)
                        value1 = BigInteger.valueOf(op2);
                    else
                        value1 = BigInteger.valueOf(op2).add(BigInteger.valueOf(relativeBase));
                    op1 = op1 / 10;
                    if(op1 % 10 == 0) {
                        if (newOp1 <= 2 || newOp1 >=5)
                            value2 = new BigInteger(items.get(op3));
                        else
                            value2 = BigInteger.valueOf(op3);
                    }
                    else if(op1 % 10 == 1)
                        value2 = BigInteger.valueOf(op3);
                    else
                        value2 = BigInteger.valueOf(op3).add(BigInteger.valueOf(relativeBase));

                    switch (newOp1) {
                        case 1:
                            items.set(op4, value1.add(value2).toString());
                            position = position + 4;
                            break;
                        case 2:
                            items.set(op4, value1.multiply(value2).toString());
                            position = position + 4;
                            break;
                        case 3:
                            items.set(value1.intValue(), "" + inputs.get(0));
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
                            if(!value1.equals(BigInteger.ZERO))
                                position = value2.intValue();
                            else
                                position = position + 3;
                            break;
                        case 6:
                            if(value1.equals(BigInteger.ZERO))
                                position = value2.intValue();
                            else
                                position = position + 3;
                            break;
                        case 7:
                            if(value1.compareTo(value2) <0)// value1 < value2)
                                items.set(op4,"1");
                            else
                                items.set(op4,"0");
                            position = position + 4;
                            break;

                        case 8:
                            if(value1.equals(value2))
                                items.set(op4,"1");
                            else
                                items.set(op4,"0");
                            position = position + 4;
                            break;
                        case 9:
                            relativeBase = value1.intValue();
                            position = position + 2;
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
