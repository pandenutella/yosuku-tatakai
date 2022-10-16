package com.pandenutella.yt.core;

import com.pandenutella.yt.core.exceptions.AllowedRepeatedMovesExceededException;
import com.pandenutella.yt.core.exceptions.InvalidNumberOfMovesInComboException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ComboTest {

    final Move MOVE_1 = buildMove("move1");
    final Move MOVE_2 = buildMove("move2");
    final Move MOVE_3 = buildMove("move3");
    final Move MOVE_4 = buildMove("move4");

    @Test
    void when_validate_given_a_moveList_of_3_should_do_nothing() throws InvalidNumberOfMovesInComboException, AllowedRepeatedMovesExceededException {
        List<Move> givenMoveList = asList(MOVE_1, MOVE_2, MOVE_3);
        Combo combo = new Combo(givenMoveList);

        combo.validate();
    }

    @Test
    void when_validate_given_a_moveList_of_2_should_throw_an_invalid_number_of_moves_in_combo_exception() {
        List<Move> givenMoveList = asList(MOVE_1, MOVE_2);
        Combo combo = new Combo(givenMoveList);

        assertThatThrownBy(combo::validate)
                .isInstanceOf(InvalidNumberOfMovesInComboException.class)
                .hasMessage("This combo has an invalid number of moves (2/3)!");
    }

    @Test
    void when_validate_given_a_moveList_of_4_should_throw_an_invalid_number_of_moves_in_combo_exception() {
        List<Move> givenMoveList = asList(MOVE_1, MOVE_2, MOVE_3, MOVE_4);
        Combo combo = new Combo(givenMoveList);

        assertThatThrownBy(combo::validate)
                .isInstanceOf(InvalidNumberOfMovesInComboException.class)
                .hasMessage("This combo has an invalid number of moves (4/3)!");
    }

    @Test
    void when_validate_given_a_moveList_of_3_where_all_are_different_should_do_nothing() throws InvalidNumberOfMovesInComboException, AllowedRepeatedMovesExceededException {
        List<Move> givenMoveList = asList(MOVE_1, MOVE_2, MOVE_3);
        Combo combo = new Combo(givenMoveList);

        combo.validate();
    }

    @Test
    void when_validate_given_a_moveList_of_3_where_2_are_the_same_should_do_nothing() throws InvalidNumberOfMovesInComboException, AllowedRepeatedMovesExceededException {
        List<Move> givenMoveList = asList(MOVE_1, MOVE_2, MOVE_2);
        Combo combo = new Combo(givenMoveList);

        combo.validate();
    }

    @Test
    void when_validate_given_a_moveList_of_3_where_all_are_the_same_should_throw_an_allowed_repeated_moves_exceeded_exception() {
        List<Move> givenMoveList = asList(MOVE_1, MOVE_1, MOVE_1);
        Combo combo = new Combo(givenMoveList);

        assertThatThrownBy(combo::validate)
                .isInstanceOf(AllowedRepeatedMovesExceededException.class)
                .hasMessage("The move1 move in this combo was used too many times (3/2)!");
    }

    @Test
    void when_getMoveList_given_a_moveList_should_return_the_moveList() {
        List<Move> givenMoveList = asList(MOVE_1, MOVE_2, MOVE_3);
        Combo combo = new Combo(givenMoveList);

        List<Move> returnedMoveList = combo.getMoveList();

        assertThat(returnedMoveList).isEqualTo(givenMoveList);
    }

    Move buildMove(String name) {
        return new Move() {
            @Override
            public String getName() {
                return name;
            }

            @Override
            public double getDamage() {
                return 0;
            }

            @Override
            public double getShield() {
                return 0;
            }

            @Override
            public Speed getSpeed() {
                return null;
            }

            @Override
            public String getPrintedString() {
                return null;
            }
        };
    }
}