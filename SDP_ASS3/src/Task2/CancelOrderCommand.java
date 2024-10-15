package Task2;

public class CancelOrderCommand implements Command {
    private TaxiService service;

    // Исправленный конструктор, который принимает TaxiService как параметр
    public CancelOrderCommand(TaxiService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.cancelOrder();
    }
}
