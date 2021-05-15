package com.anjalipancholi.methodology.sectionassignment.assignment2;

import acm.program.ConsoleProgram;

public class Fibonacci extends ConsoleProgram {

    private static final int Max_Value = 10000;

    public static void main(String[] args) {
        new Fibonacci().start();
    }

    @Override
    public void run() {
        println("This program lists the Fibonacci sequence.");
        int t1 = 0;
        int t2 = 1;
        while (t1 <= Max_Value) {
            println(t1);
            int t3 = t1 + t2;
            t1 = t2;
            t2 = t3;
        }
    }
}

