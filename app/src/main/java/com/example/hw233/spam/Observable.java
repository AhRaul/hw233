package com.example.hw233.spam;

public interface Observable {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyAllObservers();
}
