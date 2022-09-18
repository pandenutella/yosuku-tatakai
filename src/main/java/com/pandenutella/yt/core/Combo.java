package com.pandenutella.yt.core;

import com.pandenutella.yt.core.exceptions.AllowedRepeatedMovesExceededException;
import com.pandenutella.yt.core.exceptions.InvalidNumberOfMovesInComboException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Getter
public class Combo {
    private final List<Move> moveList;

    public void validate() throws InvalidNumberOfMovesInComboException, AllowedRepeatedMovesExceededException {
        int expectedNumberOfMoves = 3;
        int actualNumberOfMoves = moveList.size();

        if (actualNumberOfMoves != expectedNumberOfMoves)
            throw new InvalidNumberOfMovesInComboException(actualNumberOfMoves, expectedNumberOfMoves);

        List<String> distinctMoveNameList = moveList.stream()
                .map(Move::getName)
                .distinct()
                .collect(toList());
        if (distinctMoveNameList.size() == 1)
            throw new AllowedRepeatedMovesExceededException(distinctMoveNameList.get(0), 3, 2);
    }
}
