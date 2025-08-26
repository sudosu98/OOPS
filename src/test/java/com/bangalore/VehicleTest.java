package com.bangalore;

import com.bangalore.entities.Vehicle;
import com.bangalore.enums.Signal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VehicleTest {
    private Vehicle vehicle;

    @BeforeEach
    void setupVehicle() {
        vehicle = new Vehicle();
    }

    @Test
    void vehicleShouldStopWhenSignalIsRed() {
        vehicle.onChange(Signal.RED);
        Assertions.assertTrue(vehicle.hasStopped());
    }

    @Test
    void vehicleShouldMoveWhenSignalIsGreen() {
        vehicle.onChange(Signal.GREEN);
        Assertions.assertTrue(vehicle.isMoving());
    }

    @Test
    void vehicleShouldIgniteEngineWhenSignalIsYellow() {
        vehicle.onChange(Signal.YELLOW);
        Assertions.assertTrue(vehicle.hasStartedEngine());
    }
}
