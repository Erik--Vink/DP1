package com.niekenerik.interfaces;

import java.util.ArrayList;


public interface Node {

    ArrayList<Node> nextNodes = new ArrayList<Node>();
    Integer output =0;

    Integer calculate(int input);

    ArrayList<Node> getNextNodes();

    void setNextNodes(ArrayList<Node> nextNodes);

    Node copy();

}
