// Main.java
import controller.MovieController;
import utils.CatalogFacade;
import view.MovieView;

public class Main {
    public static void main(String[] args) {
        CatalogFacade catalog = new CatalogFacade();
        MovieView view = new MovieView();
        MovieController controller = new MovieController(catalog, view);
        controller.start();
    }

}
