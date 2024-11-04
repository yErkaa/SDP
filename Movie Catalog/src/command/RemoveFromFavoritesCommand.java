// src/command/RemoveFromFavoritesCommand.java
package command;

import model.MovieComponent;

public class RemoveFromFavoritesCommand implements Command {
    private MovieComponent movie;

    public RemoveFromFavoritesCommand(MovieComponent movie) {
        this.movie = movie;
    }

    @Override
    public void execute() {
        movie.setFavorite(false);
        System.out.println(movie.getTitle() + " удален из избранного!");
    }
}
