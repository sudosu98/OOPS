package com.bangalore.entities;

import com.bangalore.enums.Signal;
import com.bangalore.interfaces.SignalObserver;
import com.bangalore.interfaces.Subject;

import java.util.LinkedList;
import java.util.Queue;

public class Road {
    private final Subject<Signal, SignalObserver> trafficSignal;
    Queue<SignalObserver> vehicles = new LinkedList<>();

    public Road(Subject<Signal, SignalObserver> trafficSignal) {
        this.trafficSignal = trafficSignal;
    }

    public void addVehicle(SignalObserver vehicle) {
        vehicles.add(vehicle);
        trafficSignal.addObserver(vehicle);
    }

    public Queue<SignalObserver> getVehicles() {
        return vehicles;
    }

    public void removeVehicle() {
        SignalObserver vehicle = vehicles.poll();
        trafficSignal.removeObserver(vehicle);
    }

    public void moveTraffic() {
        while (!vehicles.isEmpty() && trafficSignal.getState() == Signal.GREEN) {
            removeVehicle();
        }
    }
}
