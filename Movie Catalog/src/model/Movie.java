// src/model/Movie.java
package model;

public class Movie implements MovieComponent {
    private String title;
    private int year;
    private String genre;
    private double rating;
    private boolean isFavorite;

    public Movie(String title, int year, String genre, double rating) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
        this.isFavorite = false;
    }

    // Реализация методов интерфейса MovieComponent
    public String getTitle() { return title; }
    public int getYear() { return year; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }
    public boolean isFavorite() { return isFavorite; }
    public void setFavorite(boolean isFavorite) { this.isFavorite = isFavorite; }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", isFavorite=" + isFavorite +
                '}';
    }
}
