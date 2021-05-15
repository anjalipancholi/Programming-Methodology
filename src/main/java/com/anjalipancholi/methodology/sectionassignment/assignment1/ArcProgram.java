package com.anjalipancholi.methodology.sectionassignment.assignment1;

import acm.graphics.GArc;
import acm.graphics.GPolygon;
import acm.program.GraphicsProgram;

import java.awt.*;

public class ArcProgram extends GraphicsProgram {
    public static void main(String[] args) {
        new ArcProgram().start();
    }

    public void run() {
        GArc arc = new GArc(100, 100, -90, 360);
        add(arc, 300, 100);
        arc.setFilled(true);
        arc.setFillColor(Color.RED);
        GArc narc = new GArc(100, 100, -90, 360);
        add(narc, 200, 100);
        narc.setFilled(true);
        narc.setFillColor(Color.RED);
        GPolygon triangle = new GPolygon();
        triangle.addVertex(100, 150);
        triangle.addVertex(400, 150);
        triangle.addVertex(0, 350);
        add(triangle, 300, 50);
        triangle.setFilled(true);
        triangle.setFillColor(Color.RED);
    }
}
