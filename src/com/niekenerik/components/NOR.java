package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;


public class NOR extends Node {
    private Integer inputA = -1;
    private Integer inputB = -1;

    public NOR(String name){
        super(name,"NOR");
    }

    //constructor met geen parameters om te zorgen dat de service loader de classes kan inladen
    public NOR(){
        super("","NOR");
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

        if((inputA + inputB) == 0 || (inputA + inputB) == -2){
            setOutput(1);
        } else {
            setOutput(0);
        }

        return getOutput();
    }


    @Override
    public Node copy(String name) {
        return new NOR(name);
    }
}
