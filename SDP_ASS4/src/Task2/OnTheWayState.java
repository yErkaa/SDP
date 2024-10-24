package Task2;

public class OnTheWayState implements OrderState {
    @Override
    public void handleState(OrderContext context) {
        System.out.println("Order is in On The Way state.");
        context.setState(new FinishedState());
    }
}