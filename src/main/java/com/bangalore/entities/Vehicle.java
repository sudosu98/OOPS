package com.bangalore.entities;

import com.bangalore.enums.Signal;
import com.bangalore.enums.VehicleState;

public class Vehicle {
    private VehicleState state = VehicleState.MOVING;
    private final String vehicleName;

    public Vehicle(String name) {
        this.vehicleName = name;
    }

    public String getVehicleName() {
        return this.vehicleName;
    }

    public VehicleState getState() {
        return state;
    }

    void setState(VehicleState state) {
        this.state = state;
    }

    public void drive() {
        System.out.println(this.vehicleName + " started moving");
        setState(VehicleState.MOVING);
    }

    public void brake() {
        System.out.println(this.vehicleName + " stopped");
        setState(VehicleState.STOPPED);
    }

    public void igniteEngine() {
        System.out.println(this.vehicleName + " started its engine");
        setState(VehicleState.IDLING);
    }

    public boolean isMoving() {
        return this.state == VehicleState.MOVING;
    }

    public boolean hasEngineStarted() {
        return this.state == VehicleState.MOVING || this.state == VehicleState.IDLING;
    }

    public void readSignal(Signal signal) {
        switch (signal) {
            case RED -> brake();
            case YELLOW -> igniteEngine();
            case GREEN -> drive();
        }
    }

    public void requestForEmergency(TrafficSignal trafficSignal) {
    }
}
