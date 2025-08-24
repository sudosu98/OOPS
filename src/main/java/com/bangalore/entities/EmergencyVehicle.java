package com.bangalore.entities;

import com.bangalore.enums.Signal;

public class EmergencyVehicle extends Vehicle {
    private boolean emergencyModeActive = false;
    public EmergencyVehicle(String name){
        super(name);
    }
    public boolean isEmergencyModeActive() {
        return emergencyModeActive;
    }

    void setEmergencyModeActive(boolean emergencyModeActive) {
        this.emergencyModeActive = emergencyModeActive;
    }

    @Override
    public void requestForEmergency(TrafficSignal trafficSignal){
        if(trafficSignal.isVehicleExist(this)){
            trafficSignal.activateEmergencyMode(this.getVehicleName());
            setEmergencyModeActive(trafficSignal.isEmergencyMode());
        }
    }

    @Override
    public void readSignal(Signal signal) {
        if (isEmergencyModeActive()) {
            drive();
        } else
            super.readSignal(signal);
    }
}
