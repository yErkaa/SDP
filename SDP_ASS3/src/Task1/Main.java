package Task1;

public class Main {
    public static void main(String[] args) {
        Request request = new Request(true, 100, 50, true);

        Handler carHandler = new CarAvailabilityHandler();
        Handler balanceHandler = new BalanceCheckHandler();
        Handler locationHandler = new LocationCheckHandler();

        carHandler.setNext(balanceHandler);
        balanceHandler.setNext(locationHandler);

        String result = carHandler.handle(request);
        System.out.println(result);
    }
}