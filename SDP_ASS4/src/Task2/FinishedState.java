package Task2;

public class FinishedState implements OrderState {
    @Override
    public void handleState(OrderContext context) {
        System.out.println("Order is Completed.");
    }
}