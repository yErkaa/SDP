import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import controller.MovieController;
import model.Movie;
import utils.CatalogFacade;
import view.MovieView;
import observer.User;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        CatalogFacade catalog = new CatalogFacade();
        MovieView view = new MovieView();
        MovieController controller = new MovieController(catalog, view);

        User user1 = new User("Dias");
        User user2 = new User("Abdulkadyr");

        controller.addObserver(user1);
        controller.addObserver(user2);

        ListView<Movie> allMoviesListView = new ListView<>(view.getAllMovies());
        allMoviesListView.setCellFactory(param -> new MovieCell());

        Button addToFavoriteButton = new Button("Add to favorites");
        addToFavoriteButton.setOnAction(event -> {
            Movie selectedMovie = allMoviesListView.getSelectionModel().getSelectedItem();
            if (selectedMovie != null) {
                controller.addMovieToFavorites(selectedMovie);
                allMoviesListView.getItems().remove(selectedMovie);
            }
        });

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> {
            Movie selectedMovie = allMoviesListView.getSelectionModel().getSelectedItem();
            if (selectedMovie != null) {
                controller.removeMovie(selectedMovie);
                allMoviesListView.getItems().remove(selectedMovie);
            }
        });
        VBox allMoviesTab = new VBox(10, allMoviesListView, addToFavoriteButton, deleteButton);


        ListView<Movie> favoriteMoviesListView = new ListView<>(view.getFavoriteMovies());
        favoriteMoviesListView.setCellFactory(param -> new MovieCell());

        Button removeFromFavoriteButton = new Button("Delete from favorites");
        removeFromFavoriteButton.setOnAction(event -> {
            Movie selectedMovie = favoriteMoviesListView.getSelectionModel().getSelectedItem();
            if (selectedMovie != null) {
                controller.removeMovieFromFavorites(selectedMovie);
                allMoviesListView.getItems().add(selectedMovie);
                favoriteMoviesListView.getItems().remove(selectedMovie);
            }
        });

        VBox favoriteMoviesTab = new VBox(10, favoriteMoviesListView, removeFromFavoriteButton);


        TextField titleField = new TextField();
        titleField.setPromptText("Enter movie title");
        TextField yearField = new TextField();
        yearField.setPromptText("Enter release year");
        TextField genreField = new TextField();
        genreField.setPromptText("Enter genre");
        TextField ratingField = new TextField();
        ratingField.setPromptText("Enter rating");

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> {
            String title = titleField.getText();
            int year = Integer.parseInt(yearField.getText());
            String genre = genreField.getText();
            double rating = Double.parseDouble(ratingField.getText());


            controller.addMovie(title, year, genre, rating);

            titleField.clear();
            yearField.clear();
            genreField.clear();
            ratingField.clear();
        });

        VBox addMovieTab = new VBox(10, titleField, yearField, genreField, ratingField, addButton);


        TabPane tabPane = new TabPane();
        tabPane.getTabs().add(new Tab("All films", allMoviesTab));
        tabPane.getTabs().add(new Tab("Favorites", favoriteMoviesTab));
        tabPane.getTabs().add(new Tab("Add a movie", addMovieTab));

        VBox root = new VBox(10, tabPane);
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Movie Catalog");
        primaryStage.setScene(scene);
        primaryStage.show();

        controller.showMovies();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class MovieCell extends ListCell<Movie> {
        @Override
        protected void updateItem(Movie item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null) {
                setText(item.toString());
            } else {
                setText(null);
            }
        }
    }
}