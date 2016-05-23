package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;


public class OUT implements Node {
    private Integer waarde;
    private Integer output;

    @Override
    public Integer calculate(int input) {
        waarde = input;
        output = -1;
        return output;
    }

    @Override
    public Integer getOutput() {
        return output;
    }

    @Override
    public Node copy() {
        return new OUT();
    }
}
