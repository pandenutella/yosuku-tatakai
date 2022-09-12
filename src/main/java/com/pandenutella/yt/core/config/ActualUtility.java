package com.pandenutella.yt.core.config;

import com.pandenutella.yt.core.Utility;
import com.pandenutella.yt.core.config.clocks.ActualClock;
import com.pandenutella.yt.core.config.printers.ActualPrinter;

public class ActualUtility implements Utility {
    @Override
    public Clock getClock() {
        return new ActualClock();
    }

    @Override
    public Printer getPrinter() {
        return new ActualPrinter();
    }
}
