package com.niekenerik;

import java.util.ArrayList;

public class OutputDrawer {

    public void drawLine(String line){
        System.out.println(line);
    }

    public void printError(String line){
        System.out.println("ERROR: " + line);
    }

    public void drawList(ArrayList<String> list){
        for (String item : list) {
            drawLine("- " + item);
        }
    }
}
