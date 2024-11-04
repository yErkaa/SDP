// src/model/MoveDatabase.java
package model;

import java.util.ArrayList;
import java.util.List;

public class MovieDatabase {
    private static MovieDatabase instance;
    private List<Movie> movies = new ArrayList<>();

    // Приватный конструктор для предотвращения создания экземпляров извне
    private MovieDatabase() {
    }

    // Метод для получения единственного экземпляра
    public static MovieDatabase getInstance() {
        if (instance == null) {
            instance = new MovieDatabase();
        }
        return instance;
    }

    // Метод, возвращающий список фильмов как List<MovieComponent>
    public List<MovieComponent> getMovies() {
        return new ArrayList<>(movies);
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

}