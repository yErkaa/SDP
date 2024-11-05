package utils;

import model.Movie;
import model.MovieDatabase;
import model.MovieComponent;
import observer.GenreNotifier;
import observer.Observer;

import java.util.List;

public class CatalogFacade {
    private MovieDatabase movieDatabase;
    private GenreNotifier genreNotifier;

    public CatalogFacade() {
        movieDatabase = MovieDatabase.getInstance();
        genreNotifier = new GenreNotifier();
    }

    public void addMovie(String title, int year, String genre, double rating) {
        Movie movie = new Movie(title, year, genre, rating);
        movieDatabase.addMovie(movie);
        genreNotifier.notifyNewMovie(genre, title);
    }

    public void removeMovie(MovieComponent movie) {
        if (movie instanceof Movie) {
            movieDatabase.removeMovie((Movie) movie);
        }
    }

    public List<MovieComponent> getAllMovies() {
        return movieDatabase.getMovies();
    }

    public void addObserver(Observer observer) {
        genreNotifier.addObserver(observer);
    }

}