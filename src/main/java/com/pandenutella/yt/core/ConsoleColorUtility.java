package com.pandenutella.yt.core;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class ConsoleColorUtility {
    public static String colorBy(String text, ConsoleColors color) {
        return "%s%s%s".formatted(color.getAnsi(), text, "\033[0m");
    }
}
