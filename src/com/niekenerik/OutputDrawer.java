package com.niekenerik;

import java.util.ArrayList;

public class OutputDrawer {

    public void drawLine(String line){
        System.out.println(line);
    }

    public void drawList(ArrayList<String> list){
        for (String item : list) {
            drawLine("- " + item);
        }
    }
}
