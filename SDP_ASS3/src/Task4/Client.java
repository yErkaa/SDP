package Task4;

public class Client {
    private String name;
    private DispatcherMediator mediator;

    public Client(String name, DispatcherMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void requestTaxi(String location) {
        System.out.println(name + " is requesting a taxi to " + location);
        mediator.requestTaxi(this, location);
    }

    public String getName() {
        return name;
    }
}
