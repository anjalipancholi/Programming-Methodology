package com.anjalipancholi.methodology.sectionassignment.assignment3;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

import java.awt.event.MouseEvent;

public class DrawingLines extends GraphicsProgram {

    private GLine line;

    public static void main(String[] args) {
        new DrawingLines().start();
    }

    public void run() {
        addMouseListeners();
    }

    public void mousePressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        line = new GLine(x, y, x, y);
        add(line);
    }

    public void mouseDragged(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        line.setEndPoint(x, y);
    }
}

