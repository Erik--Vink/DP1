package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;


public class OUT implements Node {
    private Integer waarde;
    @Override
    public Integer calculate(int input) {
        waarde = input;
        return -1;
    }

    @Override
    public Node copy() {
        return new OUT();
    }
}
