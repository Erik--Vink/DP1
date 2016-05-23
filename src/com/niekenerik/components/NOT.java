package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;

public class NOT implements Node {

    private Integer input =0;
    @Override
    public Integer calculate(int input) {
        this.input = input;

        if(input == 1){
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public Node copy() {
        return new NOT();
    }
}
