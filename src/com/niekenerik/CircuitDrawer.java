package com.niekenerik;

import com.niekenerik.interfaces.Node;
import com.niekenerik.interfaces.UiObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CircuitDrawer implements UiObserver {

    private String strBoldSize;
    private String strNormalSize;


    public CircuitDrawer(){
        this.strBoldSize = "\033[0;1m";
        this.strNormalSize = "\033[0;0m";
    }

    @Override
    public void update(HashMap<Node, ArrayList<String>> nodes) {

        System.out.println(strBoldSize + "Simulation circuit round");
        System.out.println(strNormalSize);

        for(Map.Entry<Node, ArrayList<String>> entry : nodes.entrySet()) {

            Node node = entry.getKey();
            ArrayList<String> nodeLinks = entry.getValue();

            System.out.println("Name: " + node.getName());
            System.out.println("Input: " + node.getInput());
            System.out.println("Type: " + node.getType());
            System.out.println("Output: " + node.getOutput());
            String nextNodes = "";
            nextNodes+= "Next nodes: ";
            for(String name : nodeLinks){
                nextNodes += name + " ";
            }
            System.out.println(nextNodes);
            System.out.println();
        }
    }
}