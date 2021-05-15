package com.anjalipancholi.methodology.miscellaneous;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class RollDice extends ConsoleProgram {

    private final RandomGenerator rgen = new RandomGenerator();

    public static void main(String[] args) {
        new RollDice().start();
    }

    @Override
    public void run() {
        int numDice = readInt("Enter the number of dice: ");
        int maxRoll = numDice * 6;
        int numRolls = 0;
        while (true) {
            int roll = rollDice(numDice);
            numRolls++;
            if (roll == maxRoll) {
                break;
            }
            println("Rolled" + roll);
        }
        println("Rolled" + maxRoll + "after" + numRolls + "rolls");
    }

    private int rollDice(int numDice) {
        int total = 0;
        for (int i = 0; i < numDice; i++) {
            total += rgen.nextInt(1, 6);
        }
        return (total);
    }
}
