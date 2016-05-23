package com.niekenerik;

import com.niekenerik.interfaces.UiObserver;

import java.util.ArrayList;

public class CircuitController {
    private Circuit circuit;
    private ArrayList<UiObserver> UiObservers;
    private FileReader fileReader;

    public CircuitController(){
        UiObservers = new ArrayList<>();
        fileReader = new FileReader();
    }

    public void start(){
        fileReader.readFile();
    }

    private void attach(){

    }

    private void notifyAllObservers(){

    }
}
