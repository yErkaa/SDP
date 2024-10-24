package Task3;

public class DistanceBasedPricing implements PricingStrategy {
    @Override
    public double calculateCost(double distance) {
        return distance * 2.0;
    }
}