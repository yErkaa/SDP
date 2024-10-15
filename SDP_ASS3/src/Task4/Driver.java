package Task4;

public class Driver {
    private String name;
    private DispatcherMediator mediator;

    public Driver(String name, DispatcherMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    // Добавляем метод getName()
    public String getName() {
        return name;
    }

    public void notify(Client client, String location) {
        System.out.println(name + " has been notified to pick up " + client.getName() + " at " + location);
    }
}

