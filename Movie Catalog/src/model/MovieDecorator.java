// src/model/MovieDecorator.java
package model;

public abstract class MovieDecorator implements MovieComponent {
    protected MovieComponent movie;

    public MovieDecorator(MovieComponent movie) {
        this.movie = movie;
    }

    // Методы интерфейса MovieComponent
    @Override
    public String getTitle() { return movie.getTitle(); }
    @Override
    public int getYear() { return movie.getYear(); }
    @Override
    public String getGenre() { return movie.getGenre(); }
    @Override
    public double getRating() { return movie.getRating(); }
    @Override
    public boolean isFavorite() { return movie.isFavorite(); }
    @Override
    public void setFavorite(boolean isFavorite) { movie.setFavorite(isFavorite); }
}

