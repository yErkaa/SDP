package controller;

import utils.CatalogFacade;
import view.MovieView;
import model.MovieComponent;
import model.MovieDatabase;
import command.AddToFavoritesCommand;
import command.RemoveFromFavoritesCommand;
import observer.User;
import model.FavoriteMovieDecorator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MovieController {
    private CatalogFacade catalog;
    private MovieView view;

    public MovieController(CatalogFacade catalog, MovieView view) {
        this.catalog = catalog;
        this.view = view;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            view.displayMessage("1. Add Movie\n2. Show All Movies\n3. Mark Movie as Favorite\n4. Remove Movie from Favorites\n5. Subscribe to Genre Notifications\n6. Unsubscribe from Genre Notifications\n7. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addMovie(scanner);
                    break;
                case 2:
                    showMovies();
                    break;
                case 3:
                    markFavorite(scanner);
                    break;
                case 4:
                    removeFavorite(scanner);
                    break;
                case 5:
                    subscribeToNotifications(scanner);
                    break;
                case 6:
                    unsubscribeFromNotifications(scanner);
                    break;
                case 7:
                    view.displayMessage("Exiting...");
                    return;
                default:
                    view.displayMessage("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private void addMovie(Scanner scanner) {
        view.displayMessage("Enter movie title:");
        String title = scanner.nextLine();

        view.displayMessage("Enter year:");
        int year = 0;
        while (true) {
            try {
                year = scanner.nextInt();
                break; // Выход из цикла, если ввод корректен
            } catch (InputMismatchException e) {
                view.displayMessage("Please enter a valid year (integer).");
                scanner.next(); // Очищаем неверный ввод
            }
        }

        view.displayMessage("Enter genre:");
        scanner.nextLine(); // Потребляем символ новой строки
        String genre = scanner.nextLine();

        view.displayMessage("Enter rating:");
        double rating = 0.0;
        while (true) {
            try {
                String input = scanner.next();
                rating = Double.parseDouble(input);
                if (input.contains(".")) {
                    break; // Valid double input
                } else {
                    view.displayMessage("Please enter a valid rating (must be a floating-point number).");
                }
            } catch (NumberFormatException e) {
                view.displayMessage("Please enter a valid rating (e.g., 5.5).");
            }
        }


        // Используем метод addMovie из CatalogFacade
        catalog.addMovie(title, year, genre, rating);
        view.displayMessage("Movie added successfully!");
    }

    private void showMovies() {
        view.displayMovies(catalog.getAllMovies());
    }

    private void markFavorite(Scanner scanner) {
        view.displayMessage("Enter title of the movie to mark as favorite:");
        String title = scanner.nextLine();

        MovieComponent movie = catalog.findMovieByTitle(title);
        if (movie != null) {
            movie = new FavoriteMovieDecorator(movie);
            new AddToFavoritesCommand(movie).execute();
        } else {
            view.displayMessage("Movie not found.");
        }
    }

    private void removeFavorite(Scanner scanner) {
        view.displayMessage("Enter title of the movie to remove from favorites:");
        String title = scanner.nextLine();

        MovieComponent movie = catalog.findMovieByTitle(title);
        if (movie != null) {
            new RemoveFromFavoritesCommand(movie).execute();
        } else {
            view.displayMessage("Movie not found.");
        }
    }

    private void subscribeToNotifications(Scanner scanner) {
        view.displayMessage("Enter your name to subscribe to notifications:");
        String name = scanner.nextLine();
        User user = new User(name);
        catalog.subscribeToGenreNotifications(user);
        view.displayMessage("Subscribed to genre notifications.");
    }
    private void unsubscribeFromNotifications(Scanner scanner) {
        view.displayMessage("Enter your name to unsubscribe from notifications:");
        String name = scanner.nextLine();
        User user = new User(name);
        catalog.unsubscribeFromGenreNotifications(user);
        view.displayMessage("Unsubscribed from genre notifications.");
    }
}