package model;

import java.util.ArrayList;
import java.util.List;

public class MovieDatabase {
    private static MovieDatabase instance;
    private List<MovieComponent> movies;
    private MovieDatabase() {
        movies = new ArrayList<>();
        initializeSampleMovies();
    }

    public static MovieDatabase getInstance() {
        if (instance == null) {
            instance = new MovieDatabase();
        }
        return instance;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
    }

    public List<MovieComponent> getMovies() {
        return new ArrayList<>(movies);
    }

    private void initializeSampleMovies() {
        movies.add(new Movie("Hachiko", 2012, "Drama ", 8.4));
        movies.add(new Movie("Harry Potter", 2001, "Fantasy ", 8.3));
        movies.add(new Movie("1 + 1", 2011, "Comedy ", 8.8));
        movies.add(new Movie(" The Shawshank Redemption", 1994, "Drama ", 9.1));
    }

}