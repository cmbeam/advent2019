package com.oddsonlogic.coding.advent;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpcodeComputer {



    String program ="";
    List<String> items;
    int extraMemory = 10000;

    int position=0;
    BigInteger output=new BigInteger("0");
    boolean done = false;
    ArrayList<Integer> inputs = new ArrayList<>();
    int relativeBase = 0;

    public OpcodeComputer(String program, int extraMemory){
        this.program = program;
        this.items = new ArrayList<>(Arrays.asList(program.split(",")));
        for (int i = 0; i <extraMemory ; i++) {
            items.add(items.size(), "0");
        }
    }

    public void reset(){
        this.position = 0;
        this.output = BigInteger.ZERO;
        this.done = false;
        this.items = new ArrayList<>(Arrays.asList(program.split(",")));
        for (int i = 0; i <extraMemory ; i++) {
            items.add(items.size(),"0");
        }
    }

    public BigInteger compute(){
        int inputCount = 0;


        BigInteger op1, op2, op3, op4;
        BigInteger value1, value2, value3;
        op1 = new BigInteger(items.get(position));

        while (op1.intValue() != 99) {

            op2 = new BigInteger(items.get(position + 1));


            op3 = new BigInteger(items.get(position + 2));

            try {
                op4 = new BigInteger(items.get(position + 3));
            } catch (Exception e){
                System.out.println(e.getMessage());
                op4 = BigInteger.ZERO;
            }



            /*
            switch (op1.intValue()) {
                case 1:
                    value1 = new BigInteger(items.get(op2.intValue()));
                    value2 = new BigInteger(items.get(op3.intValue()));
                    items.set(op4.intValue(), value1.add(value2).toString());
                    position = position + 4;
                    break;
                case 2:
                    value1 = new BigInteger(items.get(op2.intValue()));
                    value2 = new BigInteger(items.get(op3.intValue()));
                    items.set(op4.intValue(), value1.multiply(value2).toString());
                    position = position + 4;
                    break;
                case 3:
                    items.set(op2.intValue(), "" + inputs.get(0));
                    inputs.remove(0);
                    position = position + 2;
                    break;
                case 4:
                    output=new BigInteger(items.get(op2.intValue()));
                    //System.out.println("Output: " + items.get(op2.intValue()));
                    position = position + 2;
                    return output;

                case 5:
                    value1 = new BigInteger(items.get(op2.intValue()));
                    if(!value1.equals(BigInteger.ZERO))
                        position = op3.intValue();
                    else
                        position = position + 3;
                    break;
                case 6:
                    value1 = new BigInteger(items.get(op2.intValue()));
                    if(value1.equals(BigInteger.ZERO))
                        position = op3.intValue();
                    else
                        position = position + 3;
                    break;
                case 7:
                    value1 = new BigInteger(items.get(op2.intValue()));
                    value2 = new BigInteger(items.get(op3.intValue()));
                    if(value1.compareTo(value2) < 0)
                        items.set(op4.intValue(),"1");
                    else
                        items.set(op4.intValue(),"0");
                    position = position + 4;
                    break;
                case 8:
                    value1 = new BigInteger(items.get(op2.intValue()));
                    value2 = new BigInteger(items.get(op3.intValue()));
                    if(value1.equals(value2))
                        items.set(op4.intValue(),"1");
                    else
                        items.set(op4.intValue(),"0");
                    position = position + 4;
                    break;
                case 9:
                    relativeBase = relativeBase + Integer.parseInt(items.get(op2.intValue()));

                    position = position + 2;

                    break;
                default:
                */
                    int oOp1 = op1.intValue();
                    int newOp1 = op1.mod(new BigInteger("10")).intValue();

                    op1 = op1.divide(new BigInteger("100"));



                    if(op1.mod(new BigInteger("10")).equals(BigInteger.ZERO)) {
                        if(newOp1 == 3)
                            value1 = op2;
                        else
                            value1 = new BigInteger(items.get(op2.intValue()));
                    }
                    else if(op1.mod(new BigInteger("10")).equals(new BigInteger("1"))) {
                        value1 = op2;
                    }
                    else {
                        if (newOp1 == 3)// || newOp1 == 4)
                            value1 = op2.add(BigInteger.valueOf(relativeBase));
                        else
                            value1 = new BigInteger(items.get(op2.add(BigInteger.valueOf(relativeBase)).intValue()));
                    }

                    op1 = op1.divide(new BigInteger("10"));



                    if(op1.mod(new BigInteger("10")).equals(BigInteger.ZERO)) {
                        if (newOp1 ==1 || newOp1==2 || newOp1==5 || newOp1==6||newOp1==7||newOp1==8)
                            value2 = new BigInteger(items.get(op3.intValue()));
                        else
                            value2 = op3;
                    }
                    else if(op1.mod(new BigInteger("10")).equals(new BigInteger("1"))) {
                        value2 = op3;
                    }
                    else {
                        if (newOp1 ==1 || newOp1==2 || newOp1==5 || newOp1==6||newOp1==7||newOp1==8)
                            value2 = new BigInteger(items.get(op3.add(BigInteger.valueOf(relativeBase)).intValue()));
                        else
                            value2 = op3.add(BigInteger.valueOf(relativeBase));
                    }

                    op1 = op1.divide(new BigInteger("10"));



                    if(op1.mod(new BigInteger("10")).equals(new BigInteger("2"))) {
                        if ( newOp1 == 7 || newOp1 == 2 || newOp1 == 8 || newOp1 == 1)
                            value3 = op4.add(BigInteger.valueOf(relativeBase));
                        else
                            value3 = new BigInteger(items.get(op4.add(BigInteger.valueOf(relativeBase)).intValue()));
                    }
                    else {

                        if (newOp1 == 7 || newOp1 == 2 || newOp1 == 8 || newOp1 == 1)
                            value3 = op4;
                        else
                            try {
                                value3 = new BigInteger(items.get(op4.intValue()));
                            } catch(Exception e){
                                value3 = BigInteger.ZERO;
                            }
                    }





                    switch (newOp1) {
                        case 1:
                            items.set(value3.intValue(), value1.add(value2).toString());
                            position = position + 4;
                            break;
                        case 2:
                            items.set(value3.intValue(), value1.multiply(value2).toString());
                            position = position + 4;
                            break;
                        case 3:
                            items.set(value1.intValue(), "" + inputs.get(0));
                            inputs.remove(0);
                            position = position + 2;
                            break;
                        case 4:
                            //output=new BigInteger(items.get(value1.intValue()));
                            output=value1;
                           // System.out.println("Output: " + items.get(value1.intValue()));
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
                                items.set(value3.intValue(),"1");
                            else
                                items.set(value3.intValue(),"0");
                            position = position + 4;
                            break;

                        case 8:
                            if(value1.equals(value2))
                                items.set(value3.intValue(),"1");
                            else
                                items.set(value3.intValue(),"0");
                            position = position + 4;
                            break;
                        case 9:
                            relativeBase = relativeBase + value1.intValue();
                            position = position + 2;
                            break;
                        default:
                            break;
                    }

            op1 = new BigInteger(items.get(position));
        }
        this.done = true;
        System.out.println("Output99");
        return output;
    }
}
