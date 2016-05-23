package com.niekenerik;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class NodeFactory {

    private HashMap<String, Node> nodes;

    public void initialize(){

    }

    public Node createNode(String type){
        return new Node() {

            @Override
            public Integer calculate(int input) {
                return null;
            }

            @Override
            public ArrayList<Node> getNextNodes() {
                return null;
            }

            @Override
            public void setNextNodes(ArrayList<Node> nextNodes) {

            }
        };
    }
}
