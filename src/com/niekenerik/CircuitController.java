package com.niekenerik;

import com.niekenerik.interfaces.IWritter;
import com.niekenerik.interfaces.Node;
import com.niekenerik.interfaces.UiObserver;
import java.util.ArrayList;
import java.util.HashMap;

public class CircuitController extends Simulatie {
    private CircuitBuilder circuitBuilder;
    private Circuit circuit;
    private ArrayList<UiObserver> uiObservers;
    private InputReader inputReader;
    private FileReader fileReader;
    private IWritter writter;

    //initialise variable
    public CircuitController(){
        circuitBuilder = new CircuitBuilder();
        uiObservers = new ArrayList<>();
        inputReader = new InputReader();
        fileReader = new FileReader();
        writter = new LineWritter();
    }

    private void attach(UiObserver observer){
        uiObservers.add(observer);
    }

    private void notifyAllObservers(){
        for(UiObserver observer: uiObservers){
            observer.update(circuit.getDrawData());
        }
    }

    @Override
    void setupSimulation() {
        writter = new LineWritter();
        attach(new CircuitDrawer());
        writter.showMessage("Welkom bij dp1 eind opdracht");
        writter.showMessage("Selecteer het circuit");
        for(String line : fileReader.getFileNames("testFiles")){
            writter.showMessage(line);
        }
        if(fileReader.readFile(inputReader.readInput())){
            writter.showMessage("Wilt u de input waardes aanpassen? (y/n)");
            circuitBuilder.addNodes(fileReader.getNodes());
            circuitBuilder.addNodeLinks(fileReader.getNodeLinks());
            this.circuit = circuitBuilder.build();
            if(inputReader.readInput().equals("y")){
                setStartValues();
            }
        } else {
            writter.showMessage("File kon niet ingelezen worden");
            runSimulation();
        }
    }

    private void setStartValues(){
        writter = new LineWritter();
        HashMap<String, Integer> startValues = new HashMap<>();
        for(String nodeName : circuit.getToCallNodes()){
            writter.showMessage("Zet waarde node " + nodeName + ": (1/0)");
            try {
                int input = Integer.valueOf(inputReader.readInput());
                if(input == 1 || input == 2){
                    startValues.put(nodeName,input);
                }else {
                    throw new Exception();
                }

            } catch (Exception e){
                writter = new ErrorWriter();
                writter.showMessage("Voer 1 of 0 in als start waarde");
                setStartValues();
                break;
            }
        }
        circuit.setStartValues(startValues);
    }

    @Override
    void startSimulation() {
        try {
            circuit.validateCircuit();

            Boolean done = false;
            while(!done){
                done = circuit.callNodes();
                notifyAllObservers();
            }

        } catch (SimulationError simulationError) {
            writter = new ErrorWriter();
            writter.showMessage(simulationError.getMessage());
        }
    }

    @Override
    void finishSimulation() {
        writter = new LineWritter();
        writter.showMessage("De simulatie is afgelopen");
        writter.showMessage("Wilt u opnieuw een simulatie starten: (y/n)");
        if(inputReader.readInput().equals("y")){
            runSimulation();
        }
    }
}
