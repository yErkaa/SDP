package Task3;

public class Main {
    public static void main(String[] args) {
        TaxiOrder order = new TaxiOrder();

        order.setPricingStrategy(new DistanceBasedPricing());
        System.out.println("Cost based on distance: " + order.calculateCost(10));

        order.setPricingStrategy(new TimeBasedPricing());
        System.out.println("Cost based on time: " + order.calculateCost(15));

        order.setPricingStrategy(new FixedPricing());
        System.out.println("Fixed cost: " + order.calculateCost(0));
    }
}