package Task2;

public class CreateOrderCommand implements Command {
    private TaxiService service;

    public CreateOrderCommand(TaxiService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.createOrder();
    }
}
