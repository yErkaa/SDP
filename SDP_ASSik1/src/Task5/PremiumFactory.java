package Task5;


public class PremiumFactory extends Factory {

    @Override
    public Taxi createTaxi(String license) {
        Driver driver = createDriver("PremiumDriver");
        return new PremiumTaxi(driver, license);
    }

    @Override
    public Driver createDriver(String name) {
        return new PremiumDriver(name);
    }
}