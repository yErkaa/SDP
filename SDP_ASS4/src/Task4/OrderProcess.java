package Task4;

public abstract class OrderProcess {
    public final void processOrder() {
        checkAvailability();
        calculateCost();
        confirmOrder();
        finalizeOrder();
    }

    protected abstract void checkAvailability();
    protected abstract void calculateCost();
    protected abstract void confirmOrder();

    private void finalizeOrder() {
        System.out.println("Finalizing the order process...");
    }
}