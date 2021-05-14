package com.anjalipancholi.methodology.SectionAssignment.Assignment2;

import acm.graphics.GCompound;
import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.graphics.GRect;

public class GFace extends GCompound {

    private static final double eye_h = 0.15;
    private static final double eye_w = 0.15;
    private static final double nose_h = 0.10;
    private static final double nose_w = 0.15;
    private static final double mouth_h = 0.03;
    private static final double mouth_w = 0.50;
    private static final double width = 200;
    private static final double height = 300;

    private final GOval head;
    private final GOval leftEye;
    private final GOval rightEye;
    private final GRect mouth;
    private final GPolygon nose;

    public GFace(double width, double height) {
        head = new GOval(width, height);
        leftEye = new GOval(eye_w * width, eye_h * height);
        rightEye = new GOval(eye_w * width, eye_h * height);
        nose = createNose(nose_w * width, nose_h * height);
        mouth = new GRect(mouth_w * width, mouth_h * height);

        add(head, 0, 0);
        add(leftEye, 0.25 * width - eye_w * width / 2, 0.25 * height - eye_h * height / 2);
        add(rightEye, 0.25 * width - eye_w * width / 2, 0.25 * height - eye_h * height / 2);
        add(nose, 0.50 * width, 0.50 * height);
        add(mouth, 0.50 * width - mouth_w * width / 2, 0.75 * height - mouth_h * height / 2);
    }

    private GPolygon createNose(double nose_w, double nose_h) {
        GPolygon poly = new GPolygon();
        poly.addVertex(0, -nose_h);
        poly.addVertex(nose_w, nose_h);
        poly.addVertex(-nose_w, nose_h);
        return poly;
    }
}
