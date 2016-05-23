package com.niekenerik.interfaces;

import java.util.ArrayList;


public interface Node {

    ArrayList<Node> nextNodes = new ArrayList<Node>();
    Integer output =0;

    void caculate(int input);


}
