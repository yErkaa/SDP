package Task5;

public class PremiumDriver extends Driver {

    public PremiumDriver(String name) {
        super(name);
    }

    @Override
    public void drive() {
        System.out.println("Premium driver " + name + " is driving with extra comfort.");
    }
}