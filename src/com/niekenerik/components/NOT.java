package com.niekenerik.components;
import com.niekenerik.interfaces.Node;

public class NOT extends Node {

    private Integer input = -1;

    public NOT(String name){
        super(name,"NOT");
    }

    //constructor met geen parameters om te zorgen dat de service loader de classes kan inladen
    public NOT(){
        super("","NOT");
    }

    @Override
    public Integer calculate(int input) {
        this.input = input;
        if(input == 1){
            setOutput(0);
        } else {
            setOutput(1);
        }

        return getOutput();
    }


    @Override
    public Node copy(String name) {
        return new NOT(name);
    }

    @Override
    public String getInput() {
        return input.toString();
    }
}
