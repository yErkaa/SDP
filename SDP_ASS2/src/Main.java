public class Main {
    public static void main(String[] args) {
        String passenger = "Yerkin Aldongar";
        String car = "Toyota Camry";
        CarSharing carSharing = new CarSharing(car);
        TaxiService taxiService = new CarSharingAdapter(carSharing);
        taxiService.requestTaxi(passenger);
    }
}
