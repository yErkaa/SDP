package Task1;

public class Request {
    private boolean carsAvailable;
    private double balance;
    private double requiredAmount;
    private boolean locationAccessible;

    public Request(boolean carsAvailable, double balance, double requiredAmount, boolean locationAccessible) {
        this.carsAvailable = carsAvailable;
        this.balance = balance;
        this.requiredAmount = requiredAmount;
        this.locationAccessible = locationAccessible;
    }

    public boolean isCarsAvailable() {
        return carsAvailable;
    }

    public double getBalance() {
        return balance;
    }

    public double getRequiredAmount() {
        return requiredAmount;
    }

    public boolean isLocationAccessible() {
        return locationAccessible;
    }
}
