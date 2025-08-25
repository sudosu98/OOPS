package com.bangalore.entities;

public class SpecialVehicle extends Vehicle {
    private boolean isInEmergency;

    @Override
    public boolean hasRequestedEmergency() {
        return isInEmergency;
    }

    public void turnOnSiren(){
        this.isInEmergency = true;
    }

    public void turnOffSiren(){
        this.isInEmergency = false;
    }
}
