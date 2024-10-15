package Task3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("Driver A", 10));
        drivers.add(new Driver("Driver B", 5));
        drivers.add(new Driver("Driver C", 8));

        TaxiDispatchSystem system = new TaxiDispatchSystem(drivers);
        Driver closestDriver = system.assignClosestDriver();

        if (closestDriver != null) {
            System.out.println("Closest driver assigned: " + closestDriver.getName() + ", Distance: " + closestDriver.getDistance());
        }
    }
}
