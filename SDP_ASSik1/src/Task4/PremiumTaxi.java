package Task4;



public class PremiumTaxi extends Taxi {

    public PremiumTaxi(String driverName, String license) {
        super(driverName, license);
    }

    @Override
    public void takePassenger(String passenger) {
        System.out.println("Premium Taxi: Taking passenger " + passenger + " in a luxury ride.");
    }
}