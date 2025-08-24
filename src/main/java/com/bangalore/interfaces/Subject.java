package com.bangalore.interfaces;

public interface Subject {
    void addObserver(SignalObserver observer);
    void removeObserver(SignalObserver observer);
    void notifyObservers();
}
