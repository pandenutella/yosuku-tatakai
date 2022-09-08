package com.pandenutella.yt.core.enums;

import lombok.Getter;

public enum Color {
    YELLOW("\033[0;33m"),
    BLUE("\033[0;34m"),
    BOLD_RED("\033[1;31m"),
    BOLD_GREEN("\033[1;32m"),
    BOLD_YELLOW("\033[1;33m"),
    BOLD_BLUE("\033[1;34m"),
    ;

    @Getter
    private final String ansi;

    Color(String ansi) {
        this.ansi = ansi;
    }
}
