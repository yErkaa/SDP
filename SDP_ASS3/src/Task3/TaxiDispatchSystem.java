package Task3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TaxiDispatchSystem {
    private List<Driver> drivers;

    public TaxiDispatchSystem(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public Driver assignClosestDriver() {
        Collections.sort(drivers, Comparator.comparingInt(Driver::getDistance));
        DriverIterator iterator = new DriverIterator(drivers);
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }
}
