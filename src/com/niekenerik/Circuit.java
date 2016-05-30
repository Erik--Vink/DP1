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

    //initialise variable
    public Circuit(HashMap<String, Node> nodes, HashMap<String, ArrayList<Node>> nodeLinks, ArrayList<String> toCallNodes){
        this.nodes = nodes;
        this.nodeLinks = nodeLinks;
        this.toCallNodes = toCallNodes;
    }

    //Calls the nodes in toCallNodes and checks if the simulation is finished
    public Boolean callNodes() throws SimulationError {
        boolean endNodeCalled = false;

        ArrayList<String> toCallNodesNext = new ArrayList<>();

        for(String nodeName : toCallNodes){
            Integer value = nodes.get(nodeName).getOutput();
            for(Node node: nodeLinks.get(nodeName)){
                if(node.calculate(value) > -1){
                    toCallNodesNext.add(node.getName());
                }else {
                    if(node.getType().equals("OUT")){
                        endNodeCalled = true;
                    }
                }
            }
        }

        toCallNodes = toCallNodesNext;

        //if toCallNodesNext is empty the simulation is ended
        if(toCallNodesNext.size() == 0 ){
            if(endNodeCalled){
                return true;
            }else {
                throw new SimulationError("Simulation failed");
            }
        } else {
            return false;
        }

    }

    public HashMap<String, Node> getNodes() {
        return nodes;
    }
}
