package Task3;

public class FixedPricing implements PricingStrategy {
    @Override
    public double calculateCost(double value) {
        return 20.0;
    }
}