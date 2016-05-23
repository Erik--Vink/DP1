package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;


public class NOR implements Node {
    private Integer inputA = -1;
    private Integer inputB = -1;

    @Override
    public Integer calculate(int input) {
        if(inputA  == -1){
            inputA = input;
        } else {
            inputB = input;
        }

        if((inputA + inputB) == 0 || (inputA + inputB) == -2){
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Node copy() {
        return new NOR();
    }
}
