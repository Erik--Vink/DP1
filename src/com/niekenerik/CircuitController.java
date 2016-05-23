package com.niekenerik;

import com.niekenerik.interfaces.UiObserver;

import java.util.ArrayList;

public class CircuitController {
    private Circuit circuit;
    private ArrayList<UiObserver> UiObservers;
    private InputReader inputReader;

    public CircuitController(){
        UiObservers = new ArrayList<>();
        inputReader = new InputReader();
    }

    public void start(){
        inputReader.readFile();
    }

    private void attach(){

    }

    private void notifyAllObservers(){

    }
}
