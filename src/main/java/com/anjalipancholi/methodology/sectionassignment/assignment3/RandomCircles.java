package com.anjalipancholi.methodology.sectionassignment.assignment3;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class RandomCircles extends GraphicsProgram {

    private final static int MAX_CIRCLES = 50;
    private final static double MIN_RADIUS = 5;
    private final static double MAX_RADIUS = 50;
    private final static double PAUSE_T = 40;
    private final RandomGenerator rgen = RandomGenerator.getInstance();

    public static void main(String[] args) {
        new RandomCircles().start();
    }

    public void run() {
        for (int i = 0; i <= MAX_CIRCLES; i++) {
            double r = rgen.nextDouble(MIN_RADIUS, MAX_RADIUS);
            double x = rgen.nextDouble(0, getWidth() - 2 * r);
            double y = rgen.nextDouble(0, getHeight() - 2 * r);
            GOval circle = new GOval(x, y, 2 * r, 2 * r);
            circle.setFilled(true);
            circle.setColor(rgen.nextColor());
            pause(PAUSE_T);
            add(circle);
        }

    }
}
