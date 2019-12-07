package com.oddsonlogic.coding.advent;





public class Day7 {
    public static void main(String[] args) {
        boolean feedbackMode = true;

        OpcodeComputer comp1 = new OpcodeComputer();
        OpcodeComputer comp2 = new OpcodeComputer();
        OpcodeComputer comp3 = new OpcodeComputer();
        OpcodeComputer comp4 = new OpcodeComputer();
        OpcodeComputer comp5 = new OpcodeComputer();


        int largestSignal = 0;

        int signal = 0;

        int[] phases = new int[5];


        int[] inputs = new int[2];

        int[] indexes = new int[5];
        for (int i = 0; i < 5; i++) {
            indexes[i] = 0;
            if(feedbackMode)
                phases[i] = i+5;
            else
                phases[i] = i;
        }
        comp1.inputs.add(phases[0]);
        comp2.inputs.add(phases[1]);
        comp3.inputs.add(phases[2]);
        comp4.inputs.add(phases[3]);
        comp5.inputs.add(phases[4]);

        printArray(phases);
        while(!comp5.done) {
            comp1.inputs.add(signal);
            signal = comp1.compute();

            comp2.inputs.add(signal);
            signal = comp2.compute();

            comp3.inputs.add(signal);
            signal = comp3.compute();

            comp4.inputs.add(signal);
            signal = comp4.compute();

            comp5.inputs.add(signal);
            signal = comp5.compute();
        }
        System.out.println("Signal: "+signal);
        if (signal >= largestSignal)
            largestSignal = signal;
        signal=0;

        int i = 0;
        while (i < 5) {
            if (indexes[i] < i) {
                swap(phases, i % 2 == 0 ? 0 : indexes[i], i);
                printArray(phases);
                comp1.reset();
                comp2.reset();
                comp3.reset();
                comp4.reset();
                comp5.reset();
                comp1.inputs.clear();
                comp2.inputs.clear();
                comp3.inputs.clear();
                comp4.inputs.clear();
                comp5.inputs.clear();
                comp1.inputs.add(phases[0]);
                comp2.inputs.add(phases[1]);
                comp3.inputs.add(phases[2]);
                comp4.inputs.add(phases[3]);
                comp5.inputs.add(phases[4]);
                while (!comp5.done) {
                    comp1.inputs.add(signal);
                    signal = comp1.compute();

                    comp2.inputs.add(signal);
                    signal = comp2.compute();

                    comp3.inputs.add(signal);
                    signal = comp3.compute();

                    comp4.inputs.add(signal);
                    signal = comp4.compute();

                    comp5.inputs.add(signal);
                    signal = comp5.compute();
                }

                System.out.println("Signal: "+signal);
                if (signal >= largestSignal)
                    largestSignal = signal;
                signal=0;

                indexes[i]++;
                i = 0;
            }
            else {
                indexes[i] = 0;
                i++;
            }
        }

System.out.println("largest signal: "+largestSignal);



    }

    private static void printArray(int[] input) {
        System.out.print('\n');
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
        }
        System.out.println();
    }

    private static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }
}
