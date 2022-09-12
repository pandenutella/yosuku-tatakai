package com.pandenutella.yt.core;

import com.pandenutella.yt.core.config.Printer;
import com.pandenutella.yt.core.exceptions.UnknownMoveException;
import com.pandenutella.yt.core.moves.Block;
import com.pandenutella.yt.core.moves.Dodge;
import com.pandenutella.yt.core.moves.Focus;
import com.pandenutella.yt.core.moves.Jab;
import com.pandenutella.yt.core.moves.Straight;
import com.pandenutella.yt.core.moves.Uppercut;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class MoveFactory {
    private final Printer printer;

    @SneakyThrows
    public Move getMove(String name) {
        Move move = switch (name) {
            case "block" -> new Block();
            case "dodge" -> new Dodge();
            case "focus" -> new Focus();
            case "jab" -> new Jab();
            case "straight" -> new Straight();
            case "uppercut" -> new Uppercut();
            default -> throw new UnknownMoveException();
        };

        move.setPrinter(printer);

        return move;
    }
}
