package com.anjalipancholi.methodology.sectionassignment.assignment1;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class ArcheryTarget extends GraphicsProgram {
    private static final int RADIUS_OF_OUTER_CIRCLE = 72;

    public static void main(String[] args) {
        new ArcheryTarget().start();
    }

    public void run() {

        GRect circle = new GRect(RADIUS_OF_OUTER_CIRCLE, RADIUS_OF_OUTER_CIRCLE);
        add(circle, getWidth() / 2, getHeight() / 2);
    }
}
