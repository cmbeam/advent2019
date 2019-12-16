package com.oddsonlogic.coding.advent;

public class Day16 {

    public static void main(String[] args) {
        String data = "59782619540402316074783022180346847593683757122943307667976220344797950034514416918778776585040527955353805734321825495534399127207245390950629733658814914072657145711801385002282630494752854444244301169223921275844497892361271504096167480707096198155369207586705067956112600088460634830206233130995298022405587358756907593027694240400890003211841796487770173357003673931768403098808243977129249867076581200289745279553289300165042557391962340424462139799923966162395369050372874851854914571896058891964384077773019120993386024960845623120768409036628948085303152029722788889436708810209513982988162590896085150414396795104755977641352501522955134675";
        int signalLength = data.length();

        int[] signal = new int[signalLength];
        for (int i = 0; i < signalLength; i++) {
            signal[i] = Integer.parseInt(data.substring(i, i + 1));
        }

        //Pattern:  0, 1, 0, -1
        printSignal(signal);

        for (int i = 0; i < 100; i++) {

            int[] outputSignal = new int[signalLength];
            for (int j = 0; j < signalLength; j++) {
                int newSignalDigit = 0;
                int[] pattern = createPattern(j, signalLength);
                for (int k = 0; k < signalLength; k++) {

                    newSignalDigit = newSignalDigit + (signal[k] * pattern[k]);

                }
                newSignalDigit = Math.abs(newSignalDigit % 10);
                outputSignal[j] = newSignalDigit;

            }
            signal = outputSignal;


            printSignal(outputSignal);

        }


    }


    static void printSignal(int[] signal) {
        for (int j = 0; j < signal.length; j++) {
            System.out.print(signal[j]);
        }
        System.out.println();
    }

    static int[] createPattern(int iteration, int size) {
        int[] pattern = new int[size + 1];
        for (int i = 0; i < (size / 4 * (iteration + 1)); i++) {
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
        for (int i = 0; i <pattern.length-1 ; i++) {
            pattern[i] = pattern[i+1];
        }
        return pattern;
    }
}
