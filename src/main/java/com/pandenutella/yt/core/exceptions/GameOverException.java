package com.pandenutella.yt.core.exceptions;

import static java.util.Objects.nonNull;

public class GameOverException extends Exception {
    public GameOverException(String winnerName) {
        super(nonNull(winnerName)
                ? "%s won the battle!".formatted(winnerName)
                : "The battle ended with a draw!");
    }
}
