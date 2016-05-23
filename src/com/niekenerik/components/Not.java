package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;

public class Not implements Node {
    @Override
    public Integer calculate(int input) {
        return -1;
    }

    @Override
    public ArrayList<Node> getNextNodes() {
        return null;
    }

    @Override
    public void setNextNodes(ArrayList<Node> nextNodes) {

    }
}
