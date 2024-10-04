public class CarSharingAdapter implements TaxiService {
    private  CarSharing carSharing;

    public CarSharingAdapter(CarSharing carSharing) {
        this.carSharing = carSharing;
    }

    @Override
    public void requestTaxi(String passenger) {
        String driver = "Driver for passenger " + passenger;
        carSharing.rentFreeCar(driver);
    }
}