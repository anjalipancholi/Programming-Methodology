package com.anjalipancholi.methodology.miscellaneous;

import acm.program.ConsoleProgram;

public class CardRank extends ConsoleProgram {

    public static void main(String[] args) {
        new CardRank().start();
    }

    @Override
    public void run() {
        println("This program converts integer to card number.");
        int n = readInt("Enter an integer between 1 and 13: ");
        switch (n) {
            case 1:
                println("Ace");
                break;
            case 11:
                println("Jack");
                break;
            case 12:
                println("Queen");
                break;
            case 13:
                println("King");
                break;
            default:
                println(n);
                break;
        }
    }
}

