package Task5;


public class StandardTaxi extends Taxi {

    public StandardTaxi(Driver driver, String license) {
        super(driver, license);
    }

    @Override
    public void takePassenger(String passenger) {
        System.out.println("Standard Taxi: Taking " + passenger + " with driver " + driver.getName());
    }
}