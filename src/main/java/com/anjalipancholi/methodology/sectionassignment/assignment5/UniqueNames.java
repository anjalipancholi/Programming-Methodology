package com.anjalipancholi.methodology.sectionassignment.assignment5;

import acm.program.ConsoleProgram;

import java.util.ArrayList;

public class UniqueNames extends ConsoleProgram {

    public static void main(String[] args) {
        new UniqueNames().start();
    }

    public void run() {
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String name = readLine("Enter name: ");
            if (name.equals("")) {
                break;
            }
            if (!list.contains(name)) {
                list.add(name);
            }
        }
        println("Unique name list contains:");
        printList(list);
    }

    private void printList(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            println(list.get(i));
        }
    }
}

