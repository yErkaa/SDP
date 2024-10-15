package Task4;

public class Main {
    public static void main(String[] args) {
        // Создаем медиатора
        DispatcherMediator mediator = new DispatcherMediator();

        // Регистрируем диспетчера
        Dispatcher dispatcher = new Dispatcher(mediator);
        mediator.registerDispatcher(dispatcher);

        // Создаем клиентов и водителей
        Client client1 = new Client("Client 1", mediator);
        Client client2 = new Client("Client 2", mediator);

        Driver driver1 = new Driver("Driver 1", mediator);
        Driver driver2 = new Driver("Driver 2", mediator);

        // Регистрируем клиентов и водителей
        mediator.registerClient(client1);
        mediator.registerClient(client2);
        mediator.registerDriver(driver1);
        mediator.registerDriver(driver2);

        // Клиенты запрашивают такси
        client1.requestTaxi("Location A");
        client2.requestTaxi("Location B");
    }
}
