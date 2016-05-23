package com.niekenerik.components;

import com.niekenerik.interfaces.Node;

import java.util.ArrayList;

public class AND implements Node {


    @Override
    public Integer calculate(int input) {
        return 99;
    }

    @Override
    public Node copy() {
        return new AND();
    }
}
