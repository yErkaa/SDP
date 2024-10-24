package Task2;

public class CreatedState implements OrderState {
    @Override
    public void handleState(OrderContext context) {
        System.out.println("Order is in Created state.");
        context.setState(new ConfirmedState());
    }
}