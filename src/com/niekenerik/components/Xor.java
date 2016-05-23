package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;

public class XOR implements Node {
    @Override
    public Integer calculate(int input) {

        return 100;
    }

    @Override
    public ArrayList<Node> getNextNodes() {
        return null;
    }

    @Override
    public void setNextNodes(ArrayList<Node> nextNodes) {

    }

    @Override
    public Node copy() {
        return new XOR();
    }
}
