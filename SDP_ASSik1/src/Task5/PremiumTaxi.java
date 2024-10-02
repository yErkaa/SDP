package Task5;


public class PremiumTaxi extends Taxi {

    public PremiumTaxi(Driver driver, String license) {
        super(driver, license);
    }

    @Override
    public void takePassenger(String passenger) {
        System.out.println("Premium Taxi: Taking " + passenger + " in luxury with driver " + driver.getName());
    }
}