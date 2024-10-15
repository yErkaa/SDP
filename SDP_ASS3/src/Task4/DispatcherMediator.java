package Task4;

import java.util.ArrayList;
import java.util.List;

public class DispatcherMediator {
    private List<Client> clients = new ArrayList<>();
    private List<Driver> drivers = new ArrayList<>();
    private Dispatcher dispatcher;

    public void registerClient(Client client) {
        clients.add(client);
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void registerDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void requestTaxi(Client client, String location) {
        System.out.println("Mediator received request from " + client.getName() + " for a taxi to " + location);
        if (dispatcher != null) {
            dispatcher.findDriver(client, location);
        } else {
            System.out.println("No dispatcher is available.");
        }
    }

    public void findDriver(Client client, String location) {
        if (drivers.isEmpty()) {
            System.out.println("No drivers available to serve " + client.getName());
            return;
        }

        // Notify the first available driver for simplicity
        Driver driver = drivers.get(0);
        driver.notify(client, location);
        System.out.println("Driver " + driver.getName() + " has been assigned to " + client.getName());
    }
}
