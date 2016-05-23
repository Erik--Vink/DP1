package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;

public class NAND implements Node {

    private Integer inputA = -1;
    private Integer inputB = -1;

    @Override
    public Integer calculate(int input) {
        if(inputA  == -1){
            inputA = input;
        } else {
            inputB = input;
        }

        if((inputA + inputB) == 2){
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public Node copy() {
        return new NAND();
    }
}
