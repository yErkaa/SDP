import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import controller.MovieController;
import model.Movie;
import model.MovieComponent;
import utils.CatalogFacade;
import view.MovieView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        CatalogFacade catalog = new CatalogFacade();
        MovieView view = new MovieView();
        MovieController controller = new MovieController(catalog, view);

        // Вкладка "Все фильмы"
        ListView<Movie> allMoviesListView = new ListView<>(view.getAllMovies());
        allMoviesListView.setCellFactory(param -> new MovieCell());

        Button addToFavoriteButton = new Button("Добавить в избранное");
        addToFavoriteButton.setOnAction(event -> {
            Movie selectedMovie = allMoviesListView.getSelectionModel().getSelectedItem();
            if (selectedMovie != null) {
                view.addToFavorites(selectedMovie.getTitle());
                allMoviesListView.getItems().remove(selectedMovie);
            }
        });

        Button deleteButton = new Button("Удалить");
        deleteButton.setOnAction(event -> {
            Movie selectedMovie = allMoviesListView.getSelectionModel().getSelectedItem();
            if (selectedMovie != null) {
                controller.removeMovie(selectedMovie);
                allMoviesListView.getItems().remove(selectedMovie);
            }
        });
        VBox allMoviesTab = new VBox(10, allMoviesListView, addToFavoriteButton, deleteButton);

        // Вкладка "Избранное"
        ListView<Movie> favoriteMoviesListView = new ListView<>(view.getFavoriteMovies());
        favoriteMoviesListView.setCellFactory(param -> new MovieCell());

        Button removeFromFavoriteButton = new Button("Убрать из избранного");
        removeFromFavoriteButton.setOnAction(event -> {
            Movie selectedMovie = favoriteMoviesListView.getSelectionModel().getSelectedItem();
            if (selectedMovie != null) {
                view.removeFromFavorites(selectedMovie.getTitle());
                allMoviesListView.getItems().add(selectedMovie);
                favoriteMoviesListView.getItems().remove(selectedMovie);
            }
        });

        VBox favoriteMoviesTab = new VBox(10, favoriteMoviesListView, removeFromFavoriteButton);

        // Вкладка "Добавить фильм"
        TextField titleField = new TextField();
        titleField.setPromptText("Введите название фильма");
        TextField yearField = new TextField();
        yearField.setPromptText("Введите год выхода");
        TextField genreField = new TextField();
        genreField.setPromptText("Введите жанр");
        TextField ratingField = new TextField();
        ratingField.setPromptText("Введите рейтинг");

        Button addButton = new Button("Добавить");
        addButton.setOnAction(event -> {
            String title = titleField.getText();
            int year = Integer.parseInt(yearField.getText());
            String genre = genreField.getText();
            double rating = Double.parseDouble(ratingField.getText());
            MovieComponent newMovie = new Movie(title, year, genre, rating);
            controller.addMovie(newMovie);
            titleField.clear();
            yearField.clear();
            genreField.clear();
            ratingField.clear();
        });

        VBox addMovieTab = new VBox(10, titleField, yearField, genreField, ratingField, addButton);

        // Создаем табы
        TabPane tabPane = new TabPane();
        tabPane.getTabs().add(new Tab("Все фильмы", allMoviesTab));
        tabPane.getTabs().add(new Tab("Избранное", favoriteMoviesTab));
        tabPane.getTabs().add(new Tab("Добавить фильм", addMovieTab));

        VBox root = new VBox(10, tabPane);
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Movie Catalog");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Вызовите метод showMovies для инициализации списка фильмов при запуске
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