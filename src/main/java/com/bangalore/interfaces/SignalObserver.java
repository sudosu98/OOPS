package com.bangalore.interfaces;

import com.bangalore.enums.Signal;

public interface SignalObserver {
    void onSignalChange(Signal signal);
    boolean hasRequestedEmergency();
}
