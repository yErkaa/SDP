// src/view/MovieView.java
package view;

import model.MovieComponent;

import java.util.List;

public class MovieView {
    public void displayMessage(String message) {
        System.out.println(message);
    }

    // Метод для отображения списка фильмов
    public void displayMovies(List<MovieComponent> movies) {
        for (MovieComponent movie : movies) {
            System.out.println(movie.getTitle());
        }
    }
}

