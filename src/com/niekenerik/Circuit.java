package com.niekenerik;

import com.niekenerik.interfaces.Node;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Circuit {

    private ArrayList<String> toCallNodes; // Bevat de naam van node waarvan  nextnode moet worden aangeroepen
    private HashMap<String, ArrayList<Node>> nodeLinks;
    private HashMap<String, Node> nodes;

    public Circuit(HashMap<String, Node> nodes, HashMap<String, ArrayList<Node>> nodeLinks, ArrayList<String> toCallNodes){
        this.nodes = nodes;
        this.nodeLinks = nodeLinks;
        this.toCallNodes = toCallNodes;
    }

    public Boolean callNodes(){
        ArrayList<String> toCallNodesNext = new ArrayList<>();

        for(String nodeName : toCallNodes){
            Integer value = nodes.get(nodeName).getOutput();
            for(Node node: nodeLinks.get(nodeName)){
                node.calculate(value);
                toCallNodesNext.add(nodeName);
            }
        }

        return false;
    }

    public HashMap<String, Node> getNodes() {
        return nodes;
    }
}
