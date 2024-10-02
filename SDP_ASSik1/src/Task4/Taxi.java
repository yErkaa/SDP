package Task4;

public abstract class Taxi {
    protected String driverName;
    protected String license;

    public Taxi(String driverName, String license) {
        this.driverName = driverName;
        this.license = license;
    }

    public abstract void takePassenger(String passenger);
}