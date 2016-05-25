package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;

public class IN extends Node {

    public IN(String name){
        super(name);
    }

    //constructor met geen parameters om te zorgen dat de service loader de classes kan inladen
    public IN(){
        super("");
    }

    @Override
    public Integer calculate(int input) {
        setOutput(input);
        return getOutput();
    }
    @Override
    public Node copy(String name) {
        return new IN(name);
    }
}
