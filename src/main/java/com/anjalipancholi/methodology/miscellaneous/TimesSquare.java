package com.anjalipancholi.methodology.miscellaneous;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

import java.awt.*;

public class TimesSquare extends GraphicsProgram {

    private static final double PAUSE_TIME = 20;
    private static final double delta_x = 2.0;
    private static final String Headline = " TimeSquare";

    public static void main(String[] args) {
        new TimesSquare().start();
    }

    public void run() {
        GLabel label = new GLabel(Headline);
        label.setFont("Times-72");
        add(label, getWidth(), (getHeight() + label.getAscent()) / 2);
        label.setColor(Color.RED);
        while (label.getX() + label.getWidth() > 0) {
            label.move(-delta_x, 0);
            pause(PAUSE_TIME);
        }
    }
}
