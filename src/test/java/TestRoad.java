import com.bangalore.entities.EmergencyVehicle;
import com.bangalore.entities.Road;
import com.bangalore.entities.TrafficSignal;
import com.bangalore.entities.Vehicle;
import com.bangalore.enums.Signal;
import com.bangalore.enums.VehicleState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// nouns instead of verbs
public class TestRoad {
    @Test
    void testMoveTraffic(){
        TrafficSignal trafficSignal = new TrafficSignal();
        Road road = new Road(trafficSignal);
        Vehicle car = new Vehicle("Car");
        Vehicle bike = new Vehicle("Bike");
        road.addVehicle(car);
        road.addVehicle(bike);

        trafficSignal.setCurrentSignal(Signal.RED);

        // Road should have 2 vehicles
        Assertions.assertEquals(2 , road.getVehicles().size());

        trafficSignal.setCurrentSignal(Signal.GREEN);
        road.moveTraffic();
        Assertions.assertTrue(road.getVehicles().isEmpty());
    }

    @Test
    void testEmergencyVehicleEntersRoad(){
        TrafficSignal trafficSignal = new TrafficSignal();
        Road road = new Road(trafficSignal);
        Vehicle car = new Vehicle("Car");
        Vehicle bike = new Vehicle("Bike");

        road.addVehicle(car);
        road.addVehicle(bike);

        trafficSignal.setCurrentSignal(Signal.RED);

        EmergencyVehicle ambulance = new EmergencyVehicle("Ambulance");
        road.addVehicle(ambulance);

        Vehicle car2 = new Vehicle("Car2");
        road.addVehicle(car2);
        ambulance.requestForEmergency(trafficSignal);
        Assertions.assertEquals(Signal.GREEN, trafficSignal.getCurrentSignal());
        Assertions.assertTrue(trafficSignal.isEmergencyMode());
        road.moveTraffic();
        Assertions.assertEquals(VehicleState.STOPPED, car2.getState());
        // Car 2 does not exit because ambulance has passed and signal is restored.
        Assertions.assertEquals(1, road.getVehicles().size());
    }

    @Test
    void testMultipleEmergencyVehiclesOnTheRoad(){
        TrafficSignal trafficSignal = new TrafficSignal();
        Road road = new Road(trafficSignal);
        Vehicle car = new Vehicle("Car");
        Vehicle bike = new Vehicle("Bike");
        road.addVehicle(car);
        road.addVehicle(bike);

        trafficSignal.setCurrentSignal(Signal.RED);

        EmergencyVehicle ambulance = new EmergencyVehicle("Ambulance");
        road.addVehicle(ambulance);
        Vehicle car2 = new Vehicle("Car2");
        road.addVehicle(car2);
        EmergencyVehicle ambulance2 = new EmergencyVehicle("Ambulance2");
        road.addVehicle(ambulance2);
        Vehicle car3 = new Vehicle("Car3");
        road.addVehicle(car3);


        ambulance.requestForEmergency(trafficSignal);
        Assertions.assertEquals(Signal.GREEN, trafficSignal.getCurrentSignal());
        Assertions.assertTrue(trafficSignal.isEmergencyMode());
        road.moveTraffic();
        Assertions.assertEquals(VehicleState.MOVING, car2.getState());
        // Since the road had ambulance - car2 - ambulance2 - car3 only car3 should be present on road

        Assertions.assertEquals(VehicleState.STOPPED, car3.getState());
        Assertions.assertEquals(1, road.getVehicles().size());
    }

}
