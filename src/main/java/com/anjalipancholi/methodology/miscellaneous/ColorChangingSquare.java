package com.anjalipancholi.methodology.miscellaneous;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class ColorChangingSquare extends GraphicsProgram {

    private static final int s_width = 10;
    private static final int s_height = 10;
    private static final int PAUSE_TIME = 40;
    private static final int o_diam = 10;
    private final RandomGenerator rgen = RandomGenerator.getInstance();

    public static void main(String[] args) {
        new ColorChangingSquare().start();
    }

    public void run() {
        while (true) {
            GRect rect = new GRect((getWidth() - s_width) / 2, (getHeight() - s_height) / 2);
            rect.setFilled(true);
            rect.setColor(rgen.nextColor());
            pause(PAUSE_TIME);
            add(rect);

            GOval oval = new GOval(o_diam, o_diam);
            oval.setFilled(true);
            oval.setColor(rgen.nextColor());
            pause(PAUSE_TIME);
            add(oval, 5, 5);
        }
    }
}

