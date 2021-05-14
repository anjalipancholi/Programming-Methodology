package com.anjalipancholi.methodology.SectionAssignment.Assignment5;

import acm.program.ConsoleProgram;
import acm.util.ErrorException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Histograms extends ConsoleProgram {

    private static final String DATA_FILE = "methodology/MidtermScores.txt";
    private int[] histogramArray;

    public static void main(String[] args) {
        new Histograms().start();
    }

    public void run() {
        initHistogram();
        readScoresIntoHistogram();
        printHistogram();
    }

    private void initHistogram() {
        histogramArray = new int[11];
        for (int i = 0; i <= 10; i++) {
            histogramArray[i] = 0;
        }
    }

    private void readScoresIntoHistogram() {
        try {
            BufferedReader rd
                    = new BufferedReader(new FileReader(DATA_FILE));
            while (true) {
                String line = rd.readLine();
                if (line == null) {
                    break;
                }
                int score = Integer.parseInt(line);
                if (score < 0 || score > 100) {
                    throw new ErrorException("That score is out of range");
                } else {
                    int range = score / 10;
                    histogramArray[range]++;
                }
            }
        } catch (IOException ex) {
            throw new ErrorException(ex);
        }
    }

    private void printHistogram() {
        for (int range = 0; range <= 10; range++) {
            String label;
            switch (range) {
                case 0:
                    label = "00-09";
                    break;
                case 10:
                    label = " 100";
                    break;
                default:
                    label = (10 * range) + "-" + (10 * range + 9);
                    break;
            }
            String stars = createStars(histogramArray[range]);
            println(label + ": " + stars);
        }
    }

    private String createStars(int n) {
        String stars = "";
        for (int i = 0; i < n; i++) {
            stars += "*";
        }
        return stars;
    }
}

