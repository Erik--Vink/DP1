package com.niekenerik;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CircuitBuilder {

    private HashMap<String, Node> nodes;
    private HashMap<String, ArrayList<String>> nodeLinks;
    private HashMap<String, String> nodesList;

    public CircuitBuilder(){
        this.nodes = new HashMap<>();
    }

    public void addNodes(HashMap<String, String> nodes){
        this.nodesList = nodes;
    }

    public void addNodeLinks(HashMap<String, ArrayList<String>> nodeLinks){
        this.nodeLinks = nodeLinks;
    }

    public void build(){
        //Roep factory create method aan voor iedere node in nodeList
        try
        {
            for(Map.Entry<String, String> entry : nodesList.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                this.nodes.put(key, NodeFactory.create(value));
            }

            this.setLinks();
        }
        catch ( IllegalArgumentException exception )
        {
            System.out.println( exception.getMessage() );
        }
    }

    private void setLinks(){
        //Voeg voor iedere node de bijhorende nextNodes toe
        for (Map.Entry<String, ArrayList<String>> entry : this.nodeLinks.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            for(String aString : value){

                System.out.println("key : " + key + " value : " + aString);
            }
        }


    }

}
