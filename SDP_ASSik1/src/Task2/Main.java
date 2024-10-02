package Task2;


public class Main {
    public static void main(String[] args) {
        Driver originalDriver = new Driver("Michael Jordan", "Bentley", "Bentley motors", "61");

        Driver clonedDriver = originalDriver.clone();

        clonedDriver.setName("LeBron James");
        clonedDriver.setCarModel("Bugatti Chiron");

        System.out.println("Original Driver: " + originalDriver.getName() + ", Car: " + originalDriver.getCarModel());
        System.out.println("Cloned Driver: " + clonedDriver.getName() + ", Car: " + clonedDriver.getCarModel());
    }
}