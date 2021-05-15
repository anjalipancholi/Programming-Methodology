package com.anjalipancholi.methodology.miscellaneous;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

public class DraggingObjects extends GraphicsProgram {

    private double lastX;
    private double lastY;
    private GObject gobj;

    public static void main(String[] args) {
        new DraggingObjects().start();
    }

    public void run() {
        GRect rect = new GRect(100, 100, 50, 50);
        rect.setFilled(true);
        rect.setColor(Color.GREEN);
        add(rect);
        GOval oval = new GOval(300, 115, 100, 70);
        oval.setFilled(true);
        oval.setColor(Color.RED);
        add(oval);
        addMouseListeners();
    }

    public void mousePressed(MouseEvent e) {
        lastX = e.getX();
        lastY = e.getY();
        gobj = getElementAt(lastX, lastY);
    }

    public void mouseDragged(MouseEvent e) {
        if (gobj != null) {
            gobj.move(e.getX() - lastX, e.getX() - lastY);
            lastX = e.getX();
            lastY = e.getY();
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (gobj != null) {
            gobj.sendToFront();
        }
    }
}

