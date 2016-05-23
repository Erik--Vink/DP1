package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;

public class XOR implements Node {
    private Integer inputA = -1;
    private Integer inputB = -1;
    private Integer output = 0;

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

        if(inputA  != inputB  && (inputA + inputB) == -1){
            output = 1;
        } else {
            output = 0;
        }

        return output;
    }

    @Override
    public Integer getOutput() {
        return output;
    }

    @Override
    public Node copy() {
        return new XOR();
    }
}
