package com.pandenutella.yt.core.exceptions;

public class AllowedRepeatedMovesExceededException extends Exception {
    public AllowedRepeatedMovesExceededException(String moveName, int timesRepeated, int allowed) {
        super("The %s move in this combo was used too many times (%d/%d)!"
                .formatted(moveName, timesRepeated, allowed));
    }
}
