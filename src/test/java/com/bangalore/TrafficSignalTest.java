package com.bangalore;

import com.bangalore.entities.SpecialVehicle;
import com.bangalore.entities.TrafficSignal;
import com.bangalore.entities.Vehicle;
import com.bangalore.enums.Signal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrafficSignalTest {
    private TrafficSignal signal;
    private Vehicle car;

    @BeforeEach
    void setUpTrafficSignal() {
        signal = new TrafficSignal();
        car = new Vehicle();
        signal.addObserver(car);
    }

    @Test
    void vehiclesShouldGetNotifiedOfSignalChange() {
        signal.go();
        Assertions.assertTrue(car.isMoving());
        signal.stop();
        Assertions.assertTrue(car.hasStopped());
    }

    @Test
    void specialVehicleShouldChangeSignalToGreenOnlyIfInEmergency(){
        signal.stop();
        SpecialVehicle ambulance = new SpecialVehicle();
        ambulance.turnOnSiren();
        signal.addObserver(ambulance);

        Assertions.assertEquals(Signal.GREEN, signal.getCurrentSignal());
        Assertions.assertTrue(car.isMoving());
        Assertions.assertTrue(ambulance.isMoving());
    }
}
