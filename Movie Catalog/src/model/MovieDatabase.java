package model;

import java.util.ArrayList;
import java.util.List;

public class MovieDatabase {
    private static MovieDatabase instance;
    private List<MovieComponent> movies; // Список фильмов

    private MovieDatabase() {
        movies = new ArrayList<>();
        initializeSampleMovies(); // Инициализация образцов фильмов
    }

    public static MovieDatabase getInstance() {
        if (instance == null) {
            instance = new MovieDatabase(); // Создание экземпляра базы данных, если он еще не создан
        }
        return instance;
    }

    public void addMovie(Movie movie) {
        movies.add(movie); // Добавление фильма в список
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie); // Удаление фильма из списка
    }

    public List<MovieComponent> getMovies() {
        return new ArrayList<>(movies); // Возвращаем копию списка фильмов
    }

    private void initializeSampleMovies() {
        movies.add(new Movie("Фильм 1", 2020, "Жанр 1", 7.5));
        movies.add(new Movie("Фильм 2", 2021, "Жанр 2", 8.0));
        movies.add(new Movie("Фильм 3", 2019, "Жанр 3", 6.0));
        movies.add(new Movie("Фильм 4", 2022, "Жанр 4", 9.0));
    }

    public MovieComponent findMovieByTitle(String title) {
        for (MovieComponent movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie; // Возвращаем фильм, если найден
            }
        }
        return null; // Если фильм не найден, возвращаем null
    }
}