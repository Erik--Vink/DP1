package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;

public class NOT extends Node {

    public NOT(String name){
        super(name,"NOT");
    }

    //constructor met geen parameters om te zorgen dat de service loader de classes kan inladen
    public NOT(){
        super("","NOT");
    }

    @Override
    public Integer calculate(int input) {

        if(input == 1){
            setOutput(0);
        } else {
            setOutput(1);
        }

        return getOutput();
    }


    @Override
    public Node copy(String name) {
        return new NOT(name);
    }
}
