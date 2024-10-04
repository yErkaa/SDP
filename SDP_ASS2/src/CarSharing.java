public class CarSharing {
    private String car;

    public CarSharing(String car) {
        this.car = car;
    }

    public void rentFreeCar(String driver) {
        System.out.println("Car " + car + " is rented to driver " + driver);
    }
}