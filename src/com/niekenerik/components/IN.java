package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;

public class IN implements Node {

    private Integer output =0;

    @Override
    public Integer calculate(int input) {
        output = input;
        return output;
    }

    @Override
    public Integer getOutput() {
        return output;
    }

    @Override
    public Node copy() {
        return new IN();
    }
}
