package utils;

import model.Movie;
import model.MovieDatabase;
import model.MovieComponent;

import observer.GenreNotifier;

import java.util.List;

public class CatalogFacade {
    private MovieDatabase movieDatabase;
    private GenreNotifier genreNotifier;

    public CatalogFacade() {
        movieDatabase = MovieDatabase.getInstance(); // Получаем экземпляр базы данных фильмов
        genreNotifier = new GenreNotifier(); // Инициализируем уведомления по жанрам
    }

    public void addMovie(String title, int year, String genre, double rating) {
        Movie movie = new Movie(title, year, genre, rating); // Создаем новый фильм
        movieDatabase.addMovie(movie); // Добавляем фильм в базу данных
        genreNotifier.notifyNewMovie(genre, title); // Уведомляем об добавлении фильма
    }

    public void removeMovie(MovieComponent movie) {
        if (movie instanceof Movie) { // Проверяем, является ли movie экземпляром Movie
            movieDatabase.removeMovie((Movie) movie); // Удаляем фильм из базы данных
        }
    }

    public List<MovieComponent> getAllMovies() {
        return movieDatabase.getMovies(); // Получаем все фильмы из базы данных
    }

}