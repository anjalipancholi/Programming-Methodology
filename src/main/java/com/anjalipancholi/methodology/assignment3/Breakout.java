package com.anjalipancholi.methodology.assignment3;

import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.*;
import java.awt.event.MouseEvent;

import static java.awt.Color.*;

public class Breakout extends GraphicsProgram {

    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;
    /**
     * Dimensions of game board (usually the same)
     */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

    //width of paddle
    private static final int PADDLE_WIDTH = 60;

    //height of paddle
    private static final int PADDLE_HEIGHT = 10;

    //offset of paddle up from the bottom
    private static final int PADDLE_Y_OFFSET = 570;

    //number of bricks per row
    private static final int NBRICKS_PER_ROW = 10;

    //number of rows of bricks
    private static final int NBRICK_ROWS = 10;

    //separation between bricks
    private static final int BRICK_SEP = 4;

    //width of each brick (based on the dimensions of the game display)
    private static final int BRICK_WIDTH = WIDTH / NBRICKS_PER_ROW - BRICK_SEP;

    //height of brick
    private static final int BRICK_HEIGHT = 8;

    //radius of ball in pixels
    private static final int BALL_RADIUS = 6;

    //offset of the top brick row from top
    private static final int BRICK_Y_OFFSET = 70;

    //number of turns
    private static final int NTURNS = 3;

    //the paddle
    private GRect paddle;

    //the ball
    private GOval ball;

    //ball velocity in both directions (x-direction, and y-direction)
    private double vx, vy;

    //records the last x position of the mouse (see mouseMoved method)
    private double lastX;

    //used for mouse events (only moves the paddle every 5th mouse move)
    private int toggle = 0;

    //main method -- called when the program is run

    public static void main(String[] args) {
        new Breakout().start();
    }

    //run method -- called indirectly from the main method
    public void run() {
        setup();
        waitForClick();
        play();

    }

    //setup method -- called from the run method
    public void setup() {
        createBricks();
        createPaddle();
        createBall();
        addMouseListeners();
    }

    //createBricks method -- called from the setup method
    public void createBricks() {

        //make the bricks
        for (int row = 0; row < NBRICK_ROWS; row++) {
            for (int y = 0; y < NBRICKS_PER_ROW; y++) {
                GRect brick = new GRect((y * BRICK_WIDTH) + BRICK_SEP * y + BRICK_SEP / 2,
                        BRICK_Y_OFFSET + (BRICK_HEIGHT * row) + BRICK_SEP * row,
                        BRICK_WIDTH,
                        BRICK_HEIGHT);
                if (row < 2) {
                    brick.setFilled(true);
                    brick.setColor(RED);
                } else if (row > 1 && row < 4) {
                    brick.setFilled(true);
                    brick.setColor(ORANGE);
                } else if (row > 3 && row < 6) {
                    brick.setFilled(true);
                    brick.setColor(YELLOW);
                } else if (row > 5 && row < 8) {
                    brick.setFilled(true);
                    brick.setColor(GREEN);
                } else {
                    brick.setFilled(true);
                    brick.setColor(CYAN);
                }

                add(brick);
            }
        }
    }

    //createPaddle method -- called from the setup method
    public void createPaddle() {
        paddle = new GRect(0, 560, PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setFilled(true);
        paddle.setFillColor(Color.BLACK);
        add(paddle);

    }

    //createBall method -- called from the setup method
    public void createBall() {
        ball = new GOval(175, 375, 10, 10);
        ball.setFilled(true);
        add(ball);
    }

    //play method -- called from the run method after setup
    public void play() {
        startTheBall();
        playBall();
    }

    public void MouseClicked(MouseEvent e) {

    }

    //startTheBall method -- called from the play method
    public void startTheBall() {
        RandomGenerator rgen = new RandomGenerator();
        vx = rgen.nextDouble(1.0, 3.0);
        if (rgen.nextBoolean(0.5)) {
            vx = -vx;
        }
        vy = 4.0;


    }

    //playBall method -- called from the play method
    public void playBall() {
        //continuous loop
        while (true) {
            //move the ball
            ball.move(vx, vy);
            //pause
            pause(15);

            if (ball.getX() <= 0) {
                vx = -vx;
            }
            if (ball.getX() >= 400) {
                vx = -vx;
            }
            if (ball.getY() <= 0) {
                vy = -vy;
            }
            if (ball.getY() >= 600) {

                GLabel loser = new GLabel("", 5, 380);
                loser.setFont(new Font("Comic Sans", Font.BOLD, 22));
                loser.setLabel("GAME OVER! CLICK TO PLAY AGAIN.");
                add(loser);
                remove(ball);
                waitForClick();

                setup();
                waitForClick();
                play();


            }

            //check for collisions with bricks or paddle
            GObject collider = getCollidingObject();

            //if the ball collided with the paddle
            if (collider == paddle) {
                //reverse the y velocity
                vy = -vy;

            }
            //otherwise if the ball collided with a brick
            else if (collider instanceof GRect) {
                //reverse y velocity
                vy = -vy;
                //remove the brick
                remove(collider);


            }
        }
    }

    //getCollidingObject -- called from the playBall method
    //discovers and returns the object that the ball collided with
    private GObject getCollidingObject() {
        if (getElementAt(ball.getX(), ball.getY()) != null) {
            return getElementAt(ball.getX(), ball.getY());
        } else if (getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY()) != null) {
            return getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY());
        } else if (getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY() + BALL_RADIUS * 2)
                != null) {
            return getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY() + BALL_RADIUS * 2);
        } else if (getElementAt(ball.getX(), ball.getY() + BALL_RADIUS * 2) != null) {
            return getElementAt(ball.getX(), ball.getY() + BALL_RADIUS * 2);
        } else {
            return null;
        }
    }

    //mouseMoved method -- called by the mouseListener when the mouse is moved
    //anywhere within the boundaries of the run window
    public void mouseMoved(MouseEvent e) {
        //only move the paddle every 5th mouse event
        //otherwise the play slows every time the mouse moves
        if (toggle == 5) {
            //get the x-coordinate of the mouse
            double eX = e.getX();

            //if the mouse moved to the right
            if (eX - lastX > 0) {
                //if paddle is not already at the right wall
                if (paddle.getX() < WIDTH - PADDLE_WIDTH) {
                    //move to the right
                    paddle.move(eX - lastX, 0);
                }
            } else //(if the mouse moved to the left)
            {
                //if paddle is not already at the left wall
                if (paddle.getX() > 0) {
                    //move to the left
                    paddle.move(eX - lastX, 0);
                }
            }

            //record this mouse x position for next mouse event
            GPoint last = new GPoint(e.getPoint());
            lastX = last.getX();

            //reset toggle to 1
            toggle = 1;
        } else {
            //increment toggle by 1
            //(when toggle gets to 5 the code will move the paddle
            // and reset toggle back to 1)
            toggle++;
        }


    }
}
