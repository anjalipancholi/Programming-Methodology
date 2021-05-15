package com.anjalipancholi.methodology.miscellaneous;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

public class UfoGame extends GraphicsProgram {

    private static final int Ufo_Width = 40;
    private static final int Ufo_Height = 20;
    private static final int Ufo_Speed = 5;
    private static final int Bullet_Speed = 10;
    private static final int Bullet_Diam = 5;
    private static final int DELAY = 10;
    private GRect ufo;
    private GOval bullet;
    private boolean ufoToLeft;

    public static void main(String[] args) {
        new UfoGame().start();
    }

    public void run() {
        setup();
        while (!gameOver()) {
            moveUfo();
            moveBullet();
            checkForCollision();
            pause(DELAY);
        }
    }

    private void setup() {
        ufo = new GRect(Ufo_Width, Ufo_Height);
        ufo.setFilled(true);
        add(ufo, getWidth(), 0);
        ufoToLeft = true;
        addMouseListeners();
    }

    private boolean gameOver() {
        return (ufo == null) || (ufo.getY() >= getHeight() - Ufo_Height);
    }

    public void mouseClicked(MouseEvent e) {
        if (bullet == null) {
            bullet = new GOval(Bullet_Diam, Bullet_Diam);
            bullet.setFilled(true);
            bullet.setColor(Color.RED);
            add(bullet, (getWidth() - Bullet_Diam) / 2, getHeight() - Bullet_Diam);
        }
    }

    private void moveUfo() {
        if (ufoToLeft) {
            ufo.move(-Ufo_Speed, 0);
            if (ufo.getX() <= 0) {
                ufoToLeft = false;
                ufo.move(0, Ufo_Height);
            }
        } else {
            ufo.move(Ufo_Speed, 0);
            if (ufo.getWidth() >= 0) {
                ufoToLeft = true;
                ufo.move(0, Ufo_Height);
            }
        }
    }

    private void moveBullet() {
        if (bullet != null) {
            bullet.move(0, -Bullet_Speed);
        }
    }

    private void checkForCollision() {
        collideWithUfo();
        moveOffScreen();
    }

    private void collideWithUfo() {
        if (bullet == null) {
            GObject collobj = getElementAt(bullet.getX(), bullet.getY());
            if (collobj == ufo) {
                remove(ufo);
                remove(bullet);
                ufo = null;
                bullet = null;
            }
        }
    }

    private void moveOffScreen() {
        if (bullet != null) {
            if (bullet.getY() <= Bullet_Diam) {
                remove(bullet);
                bullet = null;
            }
        }
    }
}

