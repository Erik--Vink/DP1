package com.niekenerik;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CircuitBuilder {

    private HashMap<String, Node> nodes;
    private HashMap<String, ArrayList<String>> stringNodeLinks;
    private HashMap<String, String> nodesList;
    private HashMap<String, ArrayList<Node>> nodeLinks;

    public CircuitBuilder(){
        this.nodes = new HashMap<>();
        this.nodeLinks = new HashMap<>();
    }

    public void addNodes(HashMap<String, String> nodes){
        this.nodesList = nodes;
    }

    public void addNodeLinks(HashMap<String, ArrayList<String>> nodeLinks){
        this.stringNodeLinks = nodeLinks;
    }

    public Circuit build(){
        //Roep factory create method aan voor iedere node in nodeList
        HashMap<String, Node> toCallNodes = new HashMap<>();

        try
        {
            for(Map.Entry<String, String> entry : nodesList.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if((value.equals("INPUT_HIGH")) || (value.equals("INPUT_LOW"))){
                    value = "IN";
                    toCallNodes.put(key, NodeFactory.create(value));
                    //todo roep constructor met 1 of 0 aan afhankelijk van low/high
                }
                else if(value.equals("PROBE")){
                    value = "OUT";
                }
                this.nodes.put(key, NodeFactory.create(value));
            }

            this.setLinks();
            return new Circuit(this.nodes, this.nodeLinks, toCallNodes);
        }
        catch ( IllegalArgumentException exception )
        {
            System.out.println( exception.getMessage() );
            return null;
        }
    }

    private void setLinks(){
        //Voeg voor iedere node de bijhorende nextNodes toe
        for (Map.Entry<String, ArrayList<String>> entry : this.stringNodeLinks.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();

            ArrayList<Node> linkedNodes = new ArrayList<>();

            for(String node : value){
                linkedNodes.add(this.nodes.get(node));
            }
            this.nodeLinks.put(key, linkedNodes);
        }
    }

}
