package com.anjalipancholi.methodology.miscellaneous;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.event.MouseEvent;

public class DrawRectangle extends GraphicsProgram {

    private GRect currentRect;
    private double startX;
    private double startY;

    public static void main(String[] args) {
        new DrawRectangle().start();
    }

    @Override
    public void run() {
        addMouseListeners();
    }

    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
        currentRect = new GRect(startX, startY, 0, 0);
        currentRect.setFilled(true);
        add(currentRect);
    }

    public void mouseDragged(MouseEvent e) {
        double x = Math.min(e.getX(), startX);
        double y = Math.min(e.getY(), startY);
        double width = Math.abs(e.getX() - startX);
        double height = Math.abs(e.getY() - startY);
        currentRect.setBounds(x, y, width, height);
    }
}

