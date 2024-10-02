package Task3;


public class Main {
    public static void main(String[] args) {
        Driver driver = new Driver.DriverBuilder()
                .withName("Kyrie Irving")
                .withCarModel("Rolls Royce")
                .withLicenseNumber("IRV11211")
                .withExperienceYears(5)
                .isAvailable(true)
                .build();

        System.out.println(driver);
    }
}