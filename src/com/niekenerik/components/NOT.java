package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;

public class NOT implements Node {

    private Integer input =0;

    private Integer output =0;

    @Override
    public Integer calculate(int input) {
        this.input = input;

        if(input == 1){
            output =  0;
        } else {
            output = -1;
        }

        return output;
    }

    @Override
    public Integer getOutput() {
        return output;
    }

    @Override
    public Node copy() {
        return new NOT();
    }
}
