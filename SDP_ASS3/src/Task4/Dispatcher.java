package Task4;

public class Dispatcher {
    private DispatcherMediator mediator;

    public Dispatcher(DispatcherMediator mediator) {
        this.mediator = mediator;
    }

    public void findDriver(Client client, String location) {
        System.out.println("Dispatcher is finding a driver for " + client.getName() + " at " + location);
        mediator.findDriver(client, location);
    }
}
