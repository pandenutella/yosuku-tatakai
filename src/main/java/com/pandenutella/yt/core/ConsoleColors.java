package com.pandenutella.yt.core;

import lombok.Getter;

public enum ConsoleColors {
    GREEN("\033[0;32m"),
    GREEN_BACKGROUND("\033[42m"),
    YELLOW("\033[0;33m"),
    YELLOW_BACKGROUND("\033[43m"),
    RED("\033[0;31m"),
    RED_BACKGROUND("\033[41m"),
    ;

    @Getter
    String ansi;

    ConsoleColors(String ansi) {
        this.ansi = ansi;
    }
}
