package com.pandenutella.yt.core.utilities;

import com.pandenutella.yt.core.enums.Color;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class ColorUtility {
    private static final String ANSI_RESET = "\033[0m";

    public static String colorTextWith(String text, Color color) {
        return "%s%s%s".formatted(color.getAnsi(), text, ANSI_RESET);
    }
}
