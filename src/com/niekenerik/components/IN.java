package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;

public class IN implements Node {
    @Override
    public Integer calculate(int input) {
        return input;
    }

    @Override
    public Node copy() {
        return new IN();
    }
}
