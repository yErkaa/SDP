package Task2;

public class ConfirmedState implements OrderState {
    @Override
    public void handleState(OrderContext context) {
        System.out.println("Order is in Confirmed state.");
        context.setState(new OnTheWayState());
    }
}