package Task4;

public class StandardTaxiFactory extends Factory {

    @Override
    public Taxi createTaxi(String driverName, String license) {
        return new StandardTaxi(driverName, license);
    }
}