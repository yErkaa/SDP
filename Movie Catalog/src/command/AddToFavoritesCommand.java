package command;

import model.MovieComponent;

public class AddToFavoritesCommand implements Command {
    private MovieComponent movie;

    public AddToFavoritesCommand(MovieComponent movie) {
        this.movie = movie;
    }

    @Override
    public void execute() {
        movie.setFavorite(true);
        System.out.println(movie.getTitle() + " added to favorites!");
    }
}