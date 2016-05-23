package com.niekenerik;

import com.niekenerik.interfaces.UiObserver;

import java.util.ArrayList;

public class CircuitController {
    private Circuit circuit;
    private ArrayList<UiObserver> UiObservers;
    private InputReader inputReader;
    private FileReader fileReader;

    public CircuitController(){
        UiObservers = new ArrayList<>();
        inputReader = new InputReader();
        fileReader = new FileReader();
    }

    public void start(){
        fileReader.readFile("circuit1.txt");
    }

    private void attach(){

    }

    private void notifyAllObservers(){

    }
}
