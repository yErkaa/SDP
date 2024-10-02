package Task4;


public class Main {
    public static void main(String[] args) {
        Factory standardFactory = new StandardTaxiFactory();
        Taxi standardTaxi = standardFactory.createTaxi("Yerkin", "AAA111");
        standardTaxi.takePassenger("Dias");

        Factory premiumFactory = new PremiumTaxiFactory();
        Taxi premiumTaxi = premiumFactory.createTaxi("Rakhimzhan", "LOX6678");
        premiumTaxi.takePassenger("Mans");
    }
}