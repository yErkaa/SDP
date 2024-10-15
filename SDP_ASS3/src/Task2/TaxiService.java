package Task2;

public class TaxiService {
    public void createOrder() {
        System.out.println("Order created.");
    }

    public void cancelOrder() {
        System.out.println("Order canceled.");
    }

    public void changeDestination(String newDestination) {
        System.out.println("Destination changed to " + newDestination);
    }
}
