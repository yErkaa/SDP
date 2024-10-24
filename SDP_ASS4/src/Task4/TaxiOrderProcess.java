package Task4;

public class TaxiOrderProcess extends OrderProcess {
    @Override
    protected void checkAvailability() {
        System.out.println("Checking taxi availability...");
    }

    @Override
    protected void calculateCost() {
        System.out.println("Calculating trip cost...");
    }

    @Override
    protected void confirmOrder() {
        System.out.println("Confirming the taxi order...");
    }
}