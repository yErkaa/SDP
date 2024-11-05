package model;

public interface MovieComponent {
    String getTitle();
    int getYear();
    String getGenre();
    double getRating();
    boolean isFavorite();
    void setFavorite(boolean isFavorite);
}