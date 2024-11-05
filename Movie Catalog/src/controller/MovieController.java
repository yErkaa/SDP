package controller;

import utils.CatalogFacade;
import view.MovieView;
import model.MovieComponent;

public class MovieController {
    private CatalogFacade catalog;
    private MovieView view;

    public MovieController(CatalogFacade catalog, MovieView view) {
        this.catalog = catalog; // Инициализация фасада каталога
        this.view = view; // Инициализация представления
    }

    public void addMovie(MovieComponent movie) {
        catalog.addMovie(movie.getTitle(), movie.getYear(), movie.getGenre(), movie.getRating()); // Добавление фильма через фасад
        view.showAlert("Фильм добавлен: " + movie.getTitle()); // Уведомление о добавлении фильма
        showMovies(); // Обновление списка фильмов
    }

    public void showMovies() {
        view.updateMovieList(catalog.getAllMovies()); // Обновление списка фильмов в представлении
    }

    public void removeMovie(MovieComponent movie) {
        catalog.removeMovie(movie); // Удаление фильма через фасад
        showMovies(); // Обновление списка после удаления
    }

}