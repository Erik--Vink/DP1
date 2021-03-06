package com.niekenerik;

import com.niekenerik.interfaces.Node;

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
                //if this node is not the OUT node and has no links, throw an error.
                if(!nodeLinks.containsKey(node.getName()) && (!nodes.get(node.getName()).getType().equals("OUT"))){
                    throw new SimulationError("Simulation failed, unconnected pins.");
                }
                else if(node.calculate(value) > -1){
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
                throw new SimulationError("Simulation failed, node mismatch.");
            }
        } else {
            return false;
        }

    }

    public ArrayList<String> getToCallNodes() {
        return toCallNodes;
    }

    public void setStartValues(HashMap<String, Integer> startValues){
        for(Map.Entry<String, Integer> entry : startValues.entrySet()) {
            String nodeName = entry.getKey();
            Integer startValue = entry.getValue();
            this.nodes.get(nodeName).calculate(startValue);
        }
    }

    public void validateCircuit() throws SimulationError{
        try{
            callNodes();
        }
        catch(SimulationError e){
            throw e;
        }
    }

    public HashMap<Node, ArrayList<String>>getDrawData(){

        HashMap<Node, ArrayList<String>> drawData = new HashMap<>();

        for(Map.Entry<String, Node> entry : this.nodes.entrySet()) {
            String nodeKey = entry.getKey();
            Node nodeValue = entry.getValue();
            ArrayList<String> linkedNodes = new ArrayList<>();

            if(this.nodeLinks.containsKey(nodeKey)){
                for(Node linkedNode: this.nodeLinks.get(nodeKey)){
                    linkedNodes.add(linkedNode.getName());
                }
            }

            drawData.put(nodeValue,linkedNodes);
        }

        return drawData;
    }
}
