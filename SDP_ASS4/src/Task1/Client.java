package Task1;

public class Client implements Observer {
    private String name;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public void update(String status) {
        System.out.println("Client " + name + " received notification: Order status changed to " + status);
    }
}
