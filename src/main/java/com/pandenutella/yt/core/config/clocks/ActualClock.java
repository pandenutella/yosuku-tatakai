package com.pandenutella.yt.core.config.clocks;

import com.pandenutella.yt.core.config.Clock;
import lombok.SneakyThrows;

import static java.lang.Thread.sleep;

public class ActualClock implements Clock {
    @SneakyThrows
    @Override
    public void waitFor(double seconds) {
        sleep((long) (1000 * seconds));
    }
}
