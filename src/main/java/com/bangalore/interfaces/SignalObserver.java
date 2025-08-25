package com.bangalore.interfaces;

import com.bangalore.enums.Signal;

public interface SignalObserver extends Observer<Signal> {
    @Override
    void onChange(Signal signal);
    boolean hasRequestedEmergency();
}
