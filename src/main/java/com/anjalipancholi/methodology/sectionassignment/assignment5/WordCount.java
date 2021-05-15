package com.anjalipancholi.methodology.sectionassignment.assignment5;

import acm.program.ConsoleProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCount extends ConsoleProgram {

    public static void main(String[] args) {
        new WordCount().start();
    }

    public void run() {
        int lines = 0;
        int words = 0;
        int chars = 0;
        BufferedReader rd = openFileReader("File: ");
        try {
            while (true) {
                String line = rd.readLine();
                if (line == null) {
                    break;
                }
                lines++;
                words += countWords(line);
                chars += line.length();
            }
            rd.close();
        } catch (IOException ex) {
            println("An I/O exception has occured");
        }
        println("Lines =" + lines);
        println("Words =" + words);
        println("Chars =" + chars);
    }

    private BufferedReader openFileReader(String string) {
        BufferedReader rd = null;
        while (rd == null) {
            String name = readLine();
            try {
                rd = new BufferedReader(new FileReader("methodology/WordCount"));
            } catch (IOException ex) {
                println("Can't open that file.");
            }
        }
        return rd;
    }

    private int countWords(String line) {
        boolean inWord = false;
        int words = 0;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                inWord = true;
            } else {
                if (inWord) {
                    words++;
                }
                inWord = false;
            }
        }
        if (inWord) {
            words++;
        }
        return words;
    }
}
