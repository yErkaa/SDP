package Task1;

public class LocationCheckHandler extends Handler {
    @Override
    public String handle(Request request) {
        if (request.isLocationAccessible()) {
            System.out.println("Location check passed.");
            if (nextHandler != null) {
                return nextHandler.handle(request);
            }
            return "Request approved.";
        } else {
            System.out.println("Location inaccessible.");
            return "Request rejected: Location inaccessible.";
        }
    }
}
