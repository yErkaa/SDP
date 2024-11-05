package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import model.Movie;
import model.MovieComponent;

import java.util.List;

public class MovieView {
    private ObservableList<Movie> allMovies = FXCollections.observableArrayList();
    private ObservableList<Movie> favoriteMovies = FXCollections.observableArrayList();

    public ObservableList<Movie> getAllMovies() {
        return allMovies;
    }

    public ObservableList<Movie> getFavoriteMovies() {
        return favoriteMovies;
    }

    public void addToFavorites(String title) {
        Movie movie = findMovieByTitle(title);
        if (movie != null) {
            favoriteMovies.add(movie);
            allMovies.remove(movie);
        }
    }

    public void removeFromFavorites(String title) {
        Movie movie = findMovieByTitle(title);
        if (movie != null) {
            favoriteMovies.remove(movie);
            allMovies.add(movie);
        }
    }

    private Movie findMovieByTitle(String title) {
        for (Movie movie : allMovies) {
            if (movie.getTitle().equals(title)) {
                return movie;
            }
        }
        for (Movie movie : favoriteMovies) {
            if (movie.getTitle().equals(title)) {
                return movie;
            }
        }
        return null;
    }

    public void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void updateMovieList(List<MovieComponent> movies) {
        allMovies.clear();
        for (MovieComponent movie : movies) {
            if (movie instanceof Movie) {
                allMovies.add((Movie) movie);
            }
        }
    }
}