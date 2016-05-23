package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;

public class NOT extends Node {

    public NOT(String name){
        super(name);
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
