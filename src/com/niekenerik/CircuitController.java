package com.niekenerik;

import com.niekenerik.interfaces.IWritter;
import com.niekenerik.interfaces.UiObserver;
import java.util.ArrayList;

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
        writter.showMessage("Welkom bij dp1 eind opdracht");
        writter.showMessage("Selecteer het circuit");
        for(String line : fileReader.getFileNames("testFiles")){
            writter.showMessage(line);
        }
        if(fileReader.readFile(inputReader.readInput())){
            circuitBuilder.addNodes(fileReader.getNodes());
            circuitBuilder.addNodeLinks(fileReader.getNodeLinks());
            circuitBuilder.build();
            attach(new CircuitDrawer());
            this.circuit = circuitBuilder.build();
        } else {
            writter.showMessage("File kon niet ingelezen worden");
            runSimulation();
        }
    }

    @Override
    void startSimulation() {
        Boolean done = false;
        while(!done){
            try {
                done = circuit.callNodes();
            } catch (SimulationError simulationError) {
                writter = new ErrorWriter();
                writter.showMessage(simulationError.getMessage());
                break;
            }
            notifyAllObservers();
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
