package com.niekenerik;

public abstract class Simulatie {

    abstract void setupSimulation();
    abstract void startSimulation();
    abstract void finishSimulation();

    //template method
    public void runSimulation(){

        setupSimulation();

        startSimulation();

        finishSimulation();
    }
}
