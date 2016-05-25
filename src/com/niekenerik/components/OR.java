package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;


public class OR extends Node {
    private Integer inputA = -1;
    private Integer inputB = -1;

    public OR(String name){
        super(name,"OR");
    }

    //constructor met geen parameters om te zorgen dat de service loader de classes kan inladen
    public OR(){
        super("","OR");
    }

    @Override
    public Integer calculate(int input) {
        if(inputA  == -1){
            inputA = input;
        } else {
            inputB = input;
        }

        if(inputA == -1 || inputB == -1){
            return -1;
        }

        if(inputA == 1 || inputB == 1){
            setOutput(1);
        } else {
            setOutput(0);
        }

        return getOutput();
    }

    @Override
    public Node copy(String name) {
        return new OR(name);
    }
}
