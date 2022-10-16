package com.pandenutella.yt.core.config;

import com.pandenutella.yt.core.Config;
import com.pandenutella.yt.core.config.clocks.ActualClock;
import com.pandenutella.yt.core.config.printers.ActualPrinter;
import com.pandenutella.yt.core.utilities.StringUtility;

public class ActualConfig implements Config {
    @Override
    public Clock getClock() {
        return new ActualClock();
    }

    @Override
    public Printer getPrinter() {
        return new ActualPrinter();
    }

    @Override
    public StringUtility getStringUtility() {
        return new StringUtility();
    }
}
