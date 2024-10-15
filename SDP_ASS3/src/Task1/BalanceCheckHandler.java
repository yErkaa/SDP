package Task1;

public class BalanceCheckHandler extends Handler {
    @Override
    public String handle(Request request) {
        if (request.getBalance() >= request.getRequiredAmount()) {
            System.out.println("Balance check passed.");
            if (nextHandler != null) {
                return nextHandler.handle(request);
            }
            return "Request approved.";
        } else {
            System.out.println("Insufficient balance.");
            return "Request rejected: Insufficient balance.";
        }
    }
}
