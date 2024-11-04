// src/utils/MovieFactory.java
package utils;

import model.Movie;

public class MovieFactory {
    public static Movie createMovie(String title, int year, String genre, double rating) {
        return new Movie(title, year, genre, rating);
    }
}
