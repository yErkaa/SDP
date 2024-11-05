package controller;

import utils.CatalogFacade;
import view.MovieView;
import model.MovieComponent;
import model.FavoriteMovieDecorator;
import command.AddToFavoritesCommand;
import command.RemoveFromFavoritesCommand;
import utils.MovieFactory;
import observer.Observer;
public class MovieController {
    private CatalogFacade catalog;
    private MovieView view;

    public MovieController(CatalogFacade catalog, MovieView view) {
        this.catalog = catalog;
        this.view = view;
    }

    public void addMovie(String title, int year, String genre, double rating) {

        MovieComponent newMovie = MovieFactory.createMovie(title, year, genre, rating);
        catalog.addMovie(newMovie.getTitle(), newMovie.getYear(), newMovie.getGenre(), newMovie.getRating());
        view.showAlert("Movie added: " + newMovie.getTitle());
        showMovies();
    }

    public void showMovies() {
        view.updateMovieList(catalog.getAllMovies());
    }

    public void removeMovie(MovieComponent movie) {
        catalog.removeMovie(movie);
        showMovies();
    }

    public void addMovieToFavorites(MovieComponent movie) {
        FavoriteMovieDecorator decoratedMovie = new FavoriteMovieDecorator(movie);
        decoratedMovie.setFavorite(true);
        AddToFavoritesCommand command = new AddToFavoritesCommand(decoratedMovie);
        command.execute();
        view.addToFavorites(decoratedMovie.getTitle());
    }

    public void removeMovieFromFavorites(MovieComponent movie) {
        RemoveFromFavoritesCommand command = new RemoveFromFavoritesCommand(movie);
        command.execute();
        view.removeFromFavorites(movie.getTitle());
    }

    public void addObserver(Observer observer) {
        catalog.addObserver(observer);
    }

}