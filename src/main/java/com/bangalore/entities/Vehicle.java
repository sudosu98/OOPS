package com.bangalore.entities;

import com.bangalore.enums.Signal;
import com.bangalore.enums.VehicleState;
import com.bangalore.interfaces.SignalObserver;

public class Vehicle implements SignalObserver {
    private VehicleState state = VehicleState.MOVING;


    public void brake(){
        this.state = VehicleState.STOPPED;
    }

    public void drive(){
        this.state = VehicleState.MOVING;
    }

    public void igniteEngine() {
        this.state = VehicleState.IDLING;
    }

    public boolean hasStopped() {
        return state == VehicleState.STOPPED;
    }

    @Override
    public void onChange(Signal signal) {
        switch (signal){
            case RED -> brake();
            case GREEN -> drive();
            case YELLOW -> igniteEngine();
        }
    }

    public boolean isMoving() {
        return state == VehicleState.MOVING;
    }

    public boolean hasStartedEngine() {
        return state == VehicleState.IDLING;
    }

    @Override
    public boolean hasRequestedEmergency(){
        return false;
    }
}
