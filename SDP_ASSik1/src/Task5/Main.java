package Task5;


public class Main {
    public static void main(String[] args) {
        Factory standardFactory = new StandardFactory();
        Taxi standardTaxi = standardFactory.createTaxi("RROOZ12123");
        standardTaxi.takePassenger("Yerkin");

        Factory premiumFactory = new PremiumFactory();
        Taxi premiumTaxi = premiumFactory.createTaxi("JJJJ456765432");
        premiumTaxi.takePassenger("Ansar");
    }
}