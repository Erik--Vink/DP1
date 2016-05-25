package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;

public class NAND extends Node {

    private Integer inputA = -1;
    private Integer inputB = -1;

    public NAND(String name){
        super(name);
    }

    //constructor met geen parameters om te zorgen dat de service loader de classes kan inladen
    public NAND(){
        super("");
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

        if((inputA + inputB) == 2){
            setOutput(0);
        } else {
            setOutput(1);
        }

        return getOutput();
    }


    @Override
    public Node copy(String name) {
        return new NAND(name);
    }
}
