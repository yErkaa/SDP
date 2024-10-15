package Task3;

import java.util.List;

public class DriverIterator {
    private List<Driver> drivers;
    private int index = 0;

    public DriverIterator(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public boolean hasNext() {
        return index < drivers.size();
    }

    public Driver next() {
        if (hasNext()) {
            return drivers.get(index++);
        }
        return null;
    }
}
