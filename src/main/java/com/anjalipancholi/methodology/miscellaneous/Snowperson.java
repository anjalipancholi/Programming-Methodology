package com.anjalipancholi.methodology.miscellaneous;

import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Snowperson extends GraphicsProgram {

    public static void main(String[] args) {
        new Snowperson().start();
    }

    @Override
    public void run() {
        add(new GOval(120, 20, 30, 30));
        add(new GOval(125, 25, 5, 5));
        add(new GOval(140, 25, 5, 5));
        add(new GLabel("v", 132, 37));
        add(new GOval(130, 38, 10, 10));
        add(new GOval(105, 50, 60, 60));
        add(new GOval(95, 110, 80, 80));
        add(new GRect(130, 65, 10, 5));
        add(new GRect(130, 80, 10, 5));
        add(new GRect(130, 95, 10, 5));
    }
}