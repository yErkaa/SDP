package Task1;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        Client client1 = new Client("Yerkin");
        Client client2 = new Client("Aldongar");

        order.addObserver(client1);
        order.addObserver(client2);

        order.setStatus("Taxi is approaching");
        order.setStatus("Order status updated to Confirmed");
    }
}