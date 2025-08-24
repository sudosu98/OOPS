package com.bangalore.entities;

import com.bangalore.enums.Signal;

import java.util.ArrayList;
import java.util.List;

public class TrafficSignal {
    private Signal currentSignal = Signal.RED;
    private List<Vehicle> vehicles = new ArrayList<Vehicle>();
    private boolean emergencyMode = false;
    private Signal prevSignal = null;

    public Signal getCurrentSignal() {
        return currentSignal;
    }

    public void setCurrentSignal(Signal currentSignal) {
        this.currentSignal = currentSignal;
        System.out.println("Signal -> " + currentSignal);
        notifyVehicles();
    }

    public boolean isEmergencyMode() {
        return emergencyMode;
    }

    void setEmergencyMode(boolean emergencyMode) {
        this.emergencyMode = emergencyMode;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }

    private void notifyVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.readSignal(this.currentSignal);
        }
    }

    public void activateEmergencyMode(String vehicleName) {
        if (!isEmergencyMode()) {
            System.out.println(vehicleName + " has requested to activate emergency mode");
            setPrevSignal(getCurrentSignal());
            setEmergencyMode(true);
            setCurrentSignal(Signal.GREEN);
        }
    }

    public void deactivateEmergencyMode() {
        if (emergencyMode) {
            setEmergencyMode(false);
            setCurrentSignal(getPrevSignal());
            setPrevSignal(null);
        }
    }

    public boolean isVehicleExist(Vehicle vehicle) {
        return vehicles.contains(vehicle);
    }

    public Signal getPrevSignal() {
        return prevSignal;
    }

    void setPrevSignal(Signal prevSignal) {
        this.prevSignal = prevSignal;
    }
}
