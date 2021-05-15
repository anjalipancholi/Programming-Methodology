package com.anjalipancholi.methodology.sectionassignment.assignment7;

import acm.program.GraphicsProgram;

import javax.swing.*;

public class BoxDiagram extends GraphicsProgram {

    private static final int BOX_WIDTH = 120;
    private static final int BOX_HEIGHT = 50;
    private JTextField nameField;
    private JButton addButton;
    private JButton removeButton;
    private JButton clearButton;

    public static void main(String[] args) {
        new BoxDiagram().start();
    }

    public void init() {
        createController();
        addActionListeners();
        addMouseListeners();
    }

    private void createController() {
        nameField = new JTextField(20);
        nameField.addActionListener(this);
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        clearButton = new JButton("Clear");
        add(new JLabel("Name"), SOUTH);
        add(nameField, SOUTH);
        add(addButton, SOUTH);
        add(removeButton, SOUTH);
        add(clearButton, SOUTH);

    }
}

