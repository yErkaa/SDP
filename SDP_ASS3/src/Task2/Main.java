package Task2;

public class Main {
    public static void main(String[] args) {
        TaxiService service = new TaxiService();

        Command createOrder = new CreateOrderCommand(service);
        Command cancelOrder = new CancelOrderCommand(service);
        Command changeDestination = new ChangeDestinationCommand(service, "New Destination");

        CommandInvoker invoker = new CommandInvoker();
        invoker.executeCommand(createOrder);
        invoker.executeCommand(changeDestination);
        invoker.executeCommand(cancelOrder);
    }
}
