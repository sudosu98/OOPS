package com.bangalore.entities;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Road {
    private TrafficSignal signal;
    private Queue<Vehicle> vehicles = new LinkedList<Vehicle>();

    public Road(TrafficSignal trafficSignal) {
        this.signal = trafficSignal;
    }

    public Queue<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        signal.addVehicle(vehicle);
    }

    public Vehicle removeVehicle() {
        Vehicle vehicle = vehicles.poll();
        signal.removeVehicle(vehicle);
        return vehicle;
    }

    public boolean hasMoreEmergencyVehicles() {
        return vehicles.stream().anyMatch((vehicle -> vehicle instanceof EmergencyVehicle));
    }

    public void moveTraffic() {
        switch (signal.getCurrentSignal()) {
            case GREEN -> {
                while (!vehicles.isEmpty()) {
                    Vehicle vehicle = removeVehicle();
                    if (vehicle instanceof EmergencyVehicle emergencyVehicle && signal.isEmergencyMode()) {
                        System.out.println(emergencyVehicle.getVehicleName() + " has left the road");
                        if (!hasMoreEmergencyVehicles()) {
                            signal.deactivateEmergencyMode();
                            break;
                        }
                    } else
                        System.out.println(vehicle.getVehicleName() + " has left the road");
                }
            }
            case RED -> System.out.println("Signal is RED");
            case YELLOW -> System.out.println("Vehicles have started their engines");
        }
    }

}
