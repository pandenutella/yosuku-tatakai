package com.pandenutella.yt.core.clocks;

import com.pandenutella.yt.core.Clock;
import lombok.SneakyThrows;

import static java.lang.Thread.sleep;

public class ActualClock implements Clock {
    @SneakyThrows
    @Override
    public void pauseFor(double seconds) {
        sleep((long) (1000 * seconds));
    }
}
