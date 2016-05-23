package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;


public class NOR implements Node {
    @Override
    public Integer calculate(int input) {
        return -1;
    }

    @Override
    public Node copy() {
        return new NOR();
    }
}
