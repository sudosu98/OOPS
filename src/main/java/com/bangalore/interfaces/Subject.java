package com.bangalore.interfaces;

public interface Subject<S extends Enum<S>, O> {
    void addObserver(O observer);
    void removeObserver(O observer);
    void notifyObservers();
    S getState();
}
