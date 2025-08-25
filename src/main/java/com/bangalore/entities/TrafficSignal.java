package com.bangalore.entities;

import com.bangalore.enums.Signal;
import com.bangalore.interfaces.SignalObserver;
import com.bangalore.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class TrafficSignal implements Subject {
    private Signal currentSignal = Signal.YELLOW;
    private final List<SignalObserver> observers = new ArrayList<>();


    public void stop() {
        this.currentSignal = Signal.RED;
        notifyObservers();
    }

    public void go() {
        this.currentSignal = Signal.GREEN;
        notifyObservers();
    }

    public Signal getCurrentSignal(){
        return currentSignal;
    }

    @Override
    public void addObserver(SignalObserver signalObserver) {
        observers.add(signalObserver);
        if(signalObserver.hasRequestedEmergency()){
            go();
        }
        notifyObservers();
    }


    @Override
    public void removeObserver(SignalObserver signalObserver) {
        observers.remove(signalObserver);
    }

    @Override
    public void notifyObservers() {
        for(SignalObserver observer: observers){
            observer.onSignalChange(currentSignal);
        }
    }

}
