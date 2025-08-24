package com.bangalore;

import com.bangalore.entities.Vehicle;
import com.bangalore.enums.Signal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VehicleTest {
    private Vehicle vehicle;

    @BeforeEach
    void setupVehicle(){
        vehicle = new Vehicle();
    }

    @Test
    void vehicleShouldStopWhenSignalIsRed(){
        vehicle.onSignalChange(Signal.RED);
        Assertions.assertTrue(vehicle.hasStopped());
    }

    @Test
    void vehicleShouldMoveWhenSignalIsGreen(){
        vehicle.onSignalChange(Signal.GREEN);
        Assertions.assertTrue(vehicle.isMoving());
    }

    @Test
    void vehicleShouldIgniteEngineWhenSignalIsYellow(){
        vehicle.onSignalChange(Signal.YELLOW);
        Assertions.assertTrue(vehicle.hasStartedEngine());
    }
}
