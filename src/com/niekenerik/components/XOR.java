package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

public class XOR extends Node {
    private Integer inputA = -1;
    private Integer inputB = -1;

    public XOR(String name){
        super(name, "XOR");
    }

    //constructor met geen parameters om te zorgen dat de service loader de classes kan inladen
    public XOR(){
        super("","XOR");
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

        if((inputA + inputB) == 1  ){
            setOutput(1);
        } else {
            setOutput(0);
        }

        return getOutput();
    }

    @Override
    public Node copy(String name) {
        return new XOR(name);
    }

    @Override
    public String getInput() {
        return inputA.toString() + ", " + inputB.toString();
    }
}
