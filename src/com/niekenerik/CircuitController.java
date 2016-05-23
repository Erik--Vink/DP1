package com.niekenerik;

import com.niekenerik.interfaces.Node;
import com.niekenerik.interfaces.UiObserver;

import java.util.ArrayList;

public class CircuitController {
    private CircuitBuilder circuitBuilder;
    private Circuit circuit;
    private ArrayList<UiObserver> uiObservers;
    private InputReader inputReader;
    private FileReader fileReader;
    private OutputDrawer outputDrawer;

    public CircuitController(){
        circuitBuilder = new CircuitBuilder();
        uiObservers = new ArrayList<>();
        inputReader = new InputReader();
        fileReader = new FileReader();
        outputDrawer = new OutputDrawer();
    }

    public void start(){
        setup();
    }

    private void setup(){
        outputDrawer.drawLine("Welkom bij dp1 eind opdracht");
        outputDrawer.drawLine("Selecteer het circuit");
        outputDrawer.drawList(fileReader.getFileNames("testFiles"));
        if(fileReader.readFile(inputReader.readInput())){
            circuitBuilder.addNodes(fileReader.getNodes());
            circuitBuilder.addNodeLinks(fileReader.getNodeLinks());
            this.circuit = circuitBuilder.build();
        } else {
            outputDrawer.drawLine("File kon niet ingelezen worden");
            start();
        }
    }

    private void attach(){

    }

    private void notifyAllObservers(){

    }
}
