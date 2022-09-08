package com.pandenutella.yt.core.utilities;

import com.pandenutella.yt.core.enums.Speed;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class SpeedChecker {
    public static boolean isSpeedFaster(Speed speedOne, Speed speedTwo) {
        return speedOne.ordinal() >= speedTwo.ordinal();
    }
}
