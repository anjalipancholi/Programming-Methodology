package com.anjalipancholi.methodology.miscellaneous;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import com.anjalipancholi.methodology.sectionassignment.assignment2.GFace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class InterativeDrawFace extends GraphicsProgram {

    private static final double small_d = 20;
    private static final double med_d = 40;
    private static final double large_d = 60;
    private JCheckBox checkbox;
    private JRadioButton smallRB;
    private JRadioButton medRB;
    private JRadioButton largeRB;
    private JComboBox pickColor;

    public static void main(String[] args) {
        new InterativeDrawFace().start();
    }

    public void init() {
        add(new JButton("Clear"), SOUTH);
        checkbox = new JCheckBox("Front");
        checkbox.setSelected(true);
        initRadioButtons();
        initColorChooser();
        addMouseListener();
        addActionListeners();
    }

    private void addMouseListener() {
    }

    private void initColorChooser() {
        pickColor = new JComboBox();
        pickColor.addItem("Black");
        pickColor.addItem("Red");
        pickColor.addItem("Green");
        pickColor.addItem("Blue");

        pickColor.setEditable(false);
        pickColor.setSelectedItem("Black");
        add(new JLabel("Color:"), SOUTH);
        add(pickColor, SOUTH);
    }

    public void mouseClicked(MouseEvent e) {
        GObject obj;
        double diam = getDiamSize();
        if (checkbox.isSelected()) {
            obj = new GFace(diam, diam);
        } else {
            obj = new GOval(diam, diam);
        }
        obj.setColor(getCurrentColor());
        add(obj, e.getX(), e.getY());
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Clear")) {
            removeAll();
        }
    }

    private double getDiamSize() {
        double size = 0;
        if (smallRB.isSelected()) {
            size = small_d;
        } else if (medRB.isSelected()) {
            size = med_d;
        } else if (largeRB.isSelected()) {
            size = large_d;
        }
        return size;
    }

    private Color getCurrentColor() {
        String name = (String) pickColor.getSelectedItem();
        if (name.equals("Blue")) {
            return Color.BLUE;
        } else if (name.equals("Red")) {
            return Color.RED;
        } else if (name.equals("Green")) {
            return Color.GREEN;
        } else {
            return Color.BLACK;
        }
    }

    private void initRadioButtons() {
        ButtonGroup sizeBG = new ButtonGroup();
        smallRB = new JRadioButton("Small");
        medRB = new JRadioButton("Medium");
        largeRB = new JRadioButton("Large");
        sizeBG.add(smallRB);
        sizeBG.add(medRB);
        sizeBG.add(largeRB);
        medRB.setSelected(true);
        add(smallRB, SOUTH);
        add(medRB, SOUTH);
        add(largeRB, SOUTH);
    }
}
