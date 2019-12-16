package com.oddsonlogic.coding.advent;

public class Day16 {

    public static void main(String[] args) {
        String data="";
        data="59782619540402316074783022180346847593683757122943307667976220344797950034514416918778776585040527955353805734321825495534399127207245390950629733658814914072657145711801385002282630494752854444244301169223921275844497892361271504096167480707096198155369207586705067956112600088460634830206233130995298022405587358756907593027694240400890003211841796487770173357003673931768403098808243977129249867076581200289745279553289300165042557391962340424462139799923966162395369050372874851854914571896058891964384077773019120993386024960845623120768409036628948085303152029722788889436708810209513982988162590896085150414396795104755977641352501522955134675";
        data="80871224585914546619083218645595";
        data="19617804207202209144916044189917";
        //data="69317163492948606335995924319873";
        data="59782619540402316074783022180346847593683757122943307667976220344797950034514416918778776585040527955353805734321825495534399127207245390950629733658814914072657145711801385002282630494752854444244301169223921275844497892361271504096167480707096198155369207586705067956112600088460634830206233130995298022405587358756907593027694240400890003211841796487770173357003673931768403098808243977129249867076581200289745279553289300165042557391962340424462139799923966162395369050372874851854914571896058891964384077773019120993386024960845623120768409036628948085303152029722788889436708810209513982988162590896085150414396795104755977641352501522955134675";
        //data="03036732577212944063491565474664";


        boolean part2 = true;
        int multiplier = 10000;
        int signalLength = data.length();

        int[] signal = new int[signalLength*multiplier];
        for (int j = 0; j < multiplier; j++) {
            for (int i = 0; i < signalLength; i++) {
                signal[(j*signalLength) + i] = Integer.parseInt(data.substring(i, i + 1));
            }
        }
        signalLength = signal.length;


        int offset = Integer.parseInt(data.substring(0,7));
        if(part2){
            System.out.println(signalLength+ "   "+offset);
            int[] answer = new int[signalLength-offset];
            for (int i = signalLength-1; i >= offset; i--) {

                answer[i-offset] = signal[i];
            }
            for (int j = 0; j < 100 ; j++) {

                int count = 0;
                int runningTotal = 0;
                for (int i = (answer.length - 1); i >= 0; i--) {
                    //System.out.println("Signal digit "+j+" = "+signal[j]);
                    answer[i] = (runningTotal + answer[i]) % 10;
                    runningTotal = answer[i];
                    // System.out.println(answer[i]);
                    count++;

                    //System.out.println("Digit Done  count: "+count);
                    count = 0;
                }
            }
            printSignal(answer,8);

        }


        else {
            //Pattern:  0, 1, 0, -1
            int[][] pattern = new int[signalLength][signalLength];
            for (int i = 0; i < signalLength; i++) {
                pattern[i] = createPattern(i, signalLength);
            }
            System.out.print("Signal: ");
            printSignal(signal, signalLength);
            System.out.println("Length: " + signalLength);
            System.out.println(offset);
            System.out.print("Patern: ");
            printSignal(pattern[0], signalLength + 1);
            System.out.println("Length: " + pattern[0].length);

            for (int i = 0; i < 100; i++) {

                int[] outputSignal = new int[signalLength];
                for (int j = 0; j < signalLength; j++) {
                    printSignal(pattern[j], pattern[j].length - 1);
                    int newSignalDigit = 0;
                    for (int k = 0; k < signalLength; k++) {

                        newSignalDigit = newSignalDigit + (signal[k] * pattern[j][k]);

                    }
                    newSignalDigit = Math.abs(newSignalDigit % 10);
                    outputSignal[j] = newSignalDigit;

                }
                printSignal(signal, signalLength);

                signal = outputSignal;


                printSignal(outputSignal, signalLength);

            }
            // printSignal(signal,8);

        }
    }


    static void printSignal(int[] signal, int length) {
        for (int j = 0; j < length; j++) {
            System.out.print(signal[j]);
        }
        System.out.println();
    }

    static int[] createPattern(int iteration, int size) {
        int[] pattern = new int[size + 1];
        for (int i = 0; i < (size / 4 * (iteration + 1))+1; i++) {
            for (int j = 0; j < iteration + 1; j++) {
                try {
                    pattern[(i * 4 * (iteration+1)) + j] = 0;
                } catch (Exception e) {
                }
            }
            for (int j = 0; j < iteration + 1; j++) {
                try {
                    pattern[(i * 4 * (iteration+1)) + (iteration + 1) + j] = 1;
                } catch (Exception e) {
                }
            }
            for (int j = 0; j < iteration + 1; j++) {
                try {
                    pattern[(i * 4 * (iteration+1)) + ((iteration + 1) * 2) + j] = 0;
                } catch (Exception e) {
                }
            }
            for (int j = 0; j < iteration + 1; j++) {
                try {
                    pattern[(i * 4 * (iteration+1)) + ((iteration + 1) * 3) + j] = -1;
                } catch (Exception e) {
                }
            }

        }
        //printSignal(pattern,pattern.length);
        for (int i = 0; i <pattern.length-1 ; i++) {
            pattern[i] = pattern[i+1];
        }
       // printSignal(pattern,pattern.length);
        return pattern;
    }
}
