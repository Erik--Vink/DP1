package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;


public class OUT extends Node {

    public OUT(String name){
        super(name);
    }

    //constructor met geen parameters om te zorgen dat de service loader de classes kan inladen
    public OUT(){
        super("");
    }

    @Override
    public Integer calculate(int input) {
        setOutput(input);
        return -1;
    }

    @Override
    public Node copy(String name) {
        return new OUT(name);
    }
}
