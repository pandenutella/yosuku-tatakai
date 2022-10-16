package com.pandenutella.yt.core;

import com.pandenutella.yt.core.config.Clock;
import com.pandenutella.yt.core.config.Printer;
import com.pandenutella.yt.core.utilities.StringUtility;

public interface Config {
    Clock getClock();

    Printer getPrinter();

    StringUtility getStringUtility();
}
