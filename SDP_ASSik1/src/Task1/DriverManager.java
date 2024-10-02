package Task1;

public class DriverManager {
    private static volatile DriverManager instance;

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            synchronized (DriverManager.class) {
                if (instance == null) {
                    instance = new DriverManager();
                }
            }
        }
        return instance;
    }

    public String findNearestDriver(String location) {
        System.out.println("Finding nearest driver at location: " + location);
        return "Driver1";
    }
}