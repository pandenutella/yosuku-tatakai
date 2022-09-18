package com.pandenutella.yt.core.exceptions;

public class InvalidNumberOfMovesInComboException extends Exception {
    public InvalidNumberOfMovesInComboException(int actual, int expected) {
        super("This combo has an invalid number of moves (%d/%d)!"
                .formatted(actual, expected));
    }
}
