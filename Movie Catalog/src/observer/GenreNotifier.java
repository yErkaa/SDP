package observer;

import java.util.ArrayList;
import java.util.List;

public class GenreNotifier implements Observable {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void notifyNewMovie(String genre, String title) {
        String message = "Новый фильм в жанре " + genre + ": " + title;
        notifyObservers(message);
    }
}
