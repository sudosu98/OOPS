package com.bangalore.interfaces;

public interface Observer<S extends Enum<S>> {
    void onChange(S state);
}
