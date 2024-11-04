package utils;

import model.Movie;
import model.MovieDatabase;
import model.MovieComponent;
import observer.User;
import observer.GenreNotifier;

import java.util.List;

public class CatalogFacade {
    private MovieDatabase movieDatabase;
    private GenreNotifier genreNotifier;

    public CatalogFacade() {
        movieDatabase = MovieDatabase.getInstance();
        genreNotifier = new GenreNotifier();
    }

    public void addMovie(String title, int year, String genre, double rating) {
        Movie movie = MovieFactory.createMovie(title, year, genre, rating);
        movieDatabase.addMovie(movie);
        genreNotifier.notifyNewMovie(genre, title);
    }

    public List<MovieComponent> getAllMovies() {
        return movieDatabase.getMovies();
    }

    public MovieComponent findMovieByTitle(String title) {
        for (MovieComponent movie : movieDatabase.getMovies()) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }

    public void subscribeToGenreNotifications(User user) {
        genreNotifier.addObserver(user);
    }
    public void unsubscribeFromGenreNotifications(User user) {
        genreNotifier.removeObserver(user);
    }
}