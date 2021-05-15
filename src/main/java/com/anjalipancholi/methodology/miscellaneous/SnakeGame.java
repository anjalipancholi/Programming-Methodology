package com.anjalipancholi.methodology.miscellaneous;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class SnakeGame extends GraphicsProgram {

    public static void main(String[] args) {
        new SnakeGame().start();
    }

    public void run() {
        setup();
        play();
    }

    private void setup() {
        for (int i = 0; i <= 6; i++) {
            GRect snake = new GRect(i * (2 + 4), 0, 4, 4);
            add(snake);

        }
        GOval food = new GOval(10, 10);
    }

    private void play() {
    }
}
