package model;

public class FavoriteMovieDecorator extends MovieDecorator {

    public FavoriteMovieDecorator(MovieComponent movie) {
        super(movie);
    }

    @Override
    public void setFavorite(boolean isFavorite) {
        super.setFavorite(isFavorite);
        System.out.println("Movie " + getTitle() + " has been marked as favorite!");
    }

    @Override
    public String toString() {
        return movie.toString() + " [Favorite]";
    }
}