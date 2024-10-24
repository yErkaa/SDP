package Task3;

public class TimeBasedPricing implements PricingStrategy {
    @Override
    public double calculateCost(double time) {
        return time * 1.5;
    }
}