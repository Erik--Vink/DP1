package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

public class OUT extends Node {

    private Integer input = -1;

    public OUT(String name){
        super(name, "OUT");
    }

    //constructor met geen parameters om te zorgen dat de service loader de classes kan inladen
    public OUT(){
        super("", "OUT");
    }

    @Override
    public Integer calculate(int input) {
        this.input = input;
        setOutput(input);
        return -1;
    }

    @Override
    public Node copy(String name) {
        return new OUT(name);
    }

    @Override
    public String getInput() {
        return input.toString();
    }
}
