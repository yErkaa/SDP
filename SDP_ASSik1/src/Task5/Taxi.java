package Task5;

public abstract class Taxi {
    protected Driver driver;
    protected String license;

    public Taxi(Driver driver, String license) {
        this.driver = driver;
        this.license = license;
    }

    public abstract void takePassenger(String passenger);
}