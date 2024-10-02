package Task1;

public class Main {
    public static void main(String[] args) {
        DriverManager driverManager = DriverManager.getInstance();

        String nearestDriver = driverManager.findNearestDriver("Location A");

        System.out.println("Nearest driver: " + nearestDriver);
    }
}