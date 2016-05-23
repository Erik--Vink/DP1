package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;

/**
 * Created by niek on 23-5-2016.
 */
public class Nand implements Node {

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
