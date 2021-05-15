package com.anjalipancholi.methodology.sectionassignment.assignment6;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;


public class FlipImage extends GraphicsProgram {
    public static void main(String[] args) {
        GImage image = new GImage("image");
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        //flip horizontally
        int[][] pixels = image.getPixelArray();
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[0].length / 2; j++) {
                int k = width - j - 1;
                int temp = pixels[i][j];
                pixels[i][j] = pixels[i][k];
                pixels[i][k] = temp;
            }
        }
    }
}

