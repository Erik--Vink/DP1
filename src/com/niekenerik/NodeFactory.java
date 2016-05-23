package com.niekenerik;

import com.niekenerik.interfaces.Node;

import java.util.HashMap;

public class NodeFactory {

    private HashMap<String, Node> nodes;

    public void initialize(){

    }

    public Node createNode(String type){
        return new Node() {
            @Override
            public void caculate(int input) {

            }
        };
    }
}
