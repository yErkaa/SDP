package Task1;

public class CarAvailabilityHandler extends Handler {
    @Override
    public String handle(Request request) {
        if (request.isCarsAvailable()) {
            System.out.println("Car availability check passed.");
            if (nextHandler != null) {
                return nextHandler.handle(request);
            }
            return "Request approved.";
        } else {
            System.out.println("No cars available.");
            return "Request rejected: No cars available.";
        }
    }
}
