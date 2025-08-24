package com.bangalore.entities;

import com.bangalore.interfaces.SignalObserver;
import com.bangalore.interfaces.Subject;

import java.util.LinkedList;
import java.util.Queue;

public class Road {
    private final Subject trafficSignal;
    Queue<SignalObserver> vehicles = new LinkedList<SignalObserver>();

    public Road(Subject trafficSignal) {
        this.trafficSignal = trafficSignal;
    }

    public void addVehicle(SignalObserver vehicle) {
        vehicles.add(vehicle);
        trafficSignal.addObserver(vehicle);
    }
}
