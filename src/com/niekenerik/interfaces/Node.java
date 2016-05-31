package com.niekenerik.interfaces;


public abstract class Node {
    private String name;
    private Integer output;
    private String type;

    public abstract Integer calculate(int input);
    public abstract Node copy(String name);

    public Node(String name, String type){
        this.name = name;
        this.type = type;
    }

    public Integer getOutput() {
        return output;
    }

    protected void setOutput(Integer output) {
        this.output = output;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
