package com.oddsonlogic.coding.advent;

public class Day9 {
    public static void main(String[] args) {


        OpcodeComputer comp = new OpcodeComputer();
        comp.inputs.add(1);
        while(!comp.done) {
            int output = comp.compute();
            System.out.println("Output: " + output);
        }

    }
}
