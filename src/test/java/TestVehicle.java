import com.bangalore.entities.EmergencyVehicle;
import com.bangalore.entities.TrafficSignal;
import com.bangalore.entities.Vehicle;
import com.bangalore.enums.Signal;
import com.bangalore.enums.VehicleState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestVehicle {

    @Test
    void testVehicleStates(){
        Vehicle vehicle = new Vehicle("Car");
        Assertions.assertTrue(vehicle.isMoving());
        vehicle.brake();
        Assertions.assertFalse(vehicle.isMoving());
        Assertions.assertFalse(vehicle.hasEngineStarted());
        Assertions.assertEquals(VehicleState.STOPPED, vehicle.getState());
        vehicle.drive();
        Assertions.assertTrue(vehicle.isMoving());
        Assertions.assertTrue(vehicle.hasEngineStarted());
        vehicle.igniteEngine();
        Assertions.assertTrue(vehicle.hasEngineStarted());
    }

    @Test
    void testEmergencyVehicleShouldMoveRegardlessOfSignalCheck() {
        Vehicle ambulance = new EmergencyVehicle("Ambulance");
        TrafficSignal trafficSignal = new TrafficSignal();
        trafficSignal.addVehicle(ambulance);
        ambulance.requestForEmergency(trafficSignal);
        ambulance.readSignal(Signal.RED);
        Assertions.assertTrue(ambulance.isMoving());
    }
}
