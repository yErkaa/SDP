package Task2;

public class OrderContext {
    private OrderState state;

    public OrderContext() {
        state = new CreatedState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void updateState() {
        state.handleState(this);
    }
}