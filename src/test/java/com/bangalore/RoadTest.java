package com.bangalore;

import com.bangalore.entities.Road;
import com.bangalore.entities.SpecialVehicle;
import com.bangalore.entities.TrafficSignal;
import com.bangalore.entities.Vehicle;
import com.bangalore.enums.Signal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoadTest {


    @Test
    void vehiclesShouldStopWhenSignalIsRed(){
        TrafficSignal signal = new TrafficSignal();
        Road road = new Road(signal);

        Vehicle car = new Vehicle();
        Vehicle bus = new Vehicle();

        road.addVehicle(car);
        road.addVehicle(bus);

        signal.stop();

        Assertions.assertTrue(car.hasStopped());
        Assertions.assertTrue(bus.hasStopped());
    }

    @Test
    void vehiclesShouldMoveWhenSignalIsGreen(){
        TrafficSignal signal = new TrafficSignal();
        Road road = new Road(signal);

        Vehicle car = new Vehicle();
        Vehicle bus = new Vehicle();

        road.addVehicle(car);
        road.addVehicle(bus);

        signal.go();

        Assertions.assertTrue(car.isMoving());
        Assertions.assertTrue(bus.isMoving());
    }

    @Test
    void vehiclesShouldMoveWhenSpecialVehicleIsInEmergency(){
        TrafficSignal signal = new TrafficSignal();
        Road road = new Road(signal);

        Vehicle car = new Vehicle();
        Vehicle bus = new Vehicle();

        road.addVehicle(car);
        road.addVehicle(bus);
        signal.stop();

        SpecialVehicle ambulance = new SpecialVehicle();
        ambulance.turnOnSiren();

        road.addVehicle(ambulance);

        Assertions.assertEquals(Signal.GREEN, signal.getCurrentSignal());

        Assertions.assertTrue(car.isMoving());
        Assertions.assertTrue(bus.isMoving());
        Assertions.assertTrue(ambulance.isMoving());
    }

    @Test
    void vehiclesShouldNotMoveWhenSpecialVehicleIsInEmergency(){
        TrafficSignal signal = new TrafficSignal();
        Road road = new Road(signal);

        Vehicle car = new Vehicle();
        Vehicle bus = new Vehicle();

        road.addVehicle(car);
        road.addVehicle(bus);
        signal.stop();

        SpecialVehicle ambulance = new SpecialVehicle();

        road.addVehicle(ambulance);


        Assertions.assertEquals(Signal.RED, signal.getCurrentSignal());

        Assertions.assertFalse(car.isMoving());
        Assertions.assertFalse(bus.isMoving());
        Assertions.assertFalse(ambulance.isMoving());
    }
}
