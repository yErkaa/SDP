package Task4;


public class StandardTaxi extends Taxi {

    public StandardTaxi(String driverName, String license) {
        super(driverName, license);
    }

    @Override
    public void takePassenger(String passenger) {
        System.out.println("Standard Taxi: Taking passenger " + passenger + " on a regular ride.");
    }
}