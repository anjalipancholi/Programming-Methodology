package com.anjalipancholi.methodology.SectionAssignment.Assignment1;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Pyramid extends GraphicsProgram {

    private static final int BRICK_WIDTH = 15;
    private static final int BRICK_HEIGHT = 8;

    public static void main(String[] args) {
        new Pyramid().start();
    }

    public void run() {
        int xOffset = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12 - i; j++) {
                for (int k = 0; k <= i; k++) {
                    double x = k * BRICK_WIDTH;
                    double y = i * BRICK_HEIGHT;

                    GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
                    add(brick);
                }
            }
        }
    }
}
