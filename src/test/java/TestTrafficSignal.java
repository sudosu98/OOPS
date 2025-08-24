import com.bangalore.entities.TrafficSignal;
import com.bangalore.entities.Vehicle;
import com.bangalore.enums.Signal;
import com.bangalore.enums.VehicleState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTrafficSignal {

    @Test
    void testVehiclesAreNotifiedOnSignalChange() {
        Vehicle car = new Vehicle("Car");
        TrafficSignal trafficSignal = new TrafficSignal();
        trafficSignal.addVehicle(car);
        trafficSignal.setCurrentSignal(Signal.GREEN);

        // car should change its state to Moving
        Assertions.assertTrue(car.isMoving());

        trafficSignal.setCurrentSignal(Signal.RED);
        // car should change its state to Stopped
        Assertions.assertEquals(VehicleState.STOPPED, car.getState());

    }

    @Test
    void testEmergencyModeSetsSignalToGreen(){
        TrafficSignal trafficSignal = new TrafficSignal();
        trafficSignal.activateEmergencyMode("Emergency Vehicle");
        Assertions.assertEquals(Signal.GREEN, trafficSignal.getCurrentSignal());
    }

    @Test
    void testDeactivatingEmergencyModeShouldRevertToPreviousSignal(){
        TrafficSignal trafficSignal = new TrafficSignal();
        trafficSignal.setCurrentSignal(Signal.RED);
        trafficSignal.activateEmergencyMode("Emergency Vehicle");
        Assertions.assertEquals(Signal.GREEN, trafficSignal.getCurrentSignal());
        Assertions.assertEquals(Signal.RED, trafficSignal.getPrevSignal());
        trafficSignal.deactivateEmergencyMode();
        Assertions.assertEquals(Signal.RED, trafficSignal.getCurrentSignal());
    }
}
