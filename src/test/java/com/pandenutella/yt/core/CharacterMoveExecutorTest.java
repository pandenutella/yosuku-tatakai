package com.pandenutella.yt.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.pandenutella.yt.core.Speed.FAST;
import static com.pandenutella.yt.core.Speed.SLOW;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CharacterMoveExecutorTest {

    @Mock
    GameCharacter target;

    @Mock
    Move characterMove;

    @Mock
    Move targetMove;

    CharacterMoveExecutor executor;

    @BeforeEach
    void setUp() {
        executor = new CharacterMoveExecutor(target);
    }

    @Test
    void when_execute_given_characterMove_is_faster_than_targetMove_should_perform_character_move() {
        double characterMoveDamage = 10;

        when(characterMove.getSpeed()).thenReturn(FAST);
        when(characterMove.getDamage()).thenReturn(characterMoveDamage);

        when(targetMove.getSpeed()).thenReturn(SLOW);

        executor.execute(characterMove, targetMove);

        verify(target).receiveDamage(characterMoveDamage);
    }

    @Test
    void when_execute_given_characterMove_has_the_same_speed_as_targetMove_should_perform_character_move_considering_targetMove_damage_and_shield() {
        double characterMoveDamage = 10;
        double targetMoveDamage = 4;
        double targetMoveShield = 3;

        when(characterMove.getSpeed()).thenReturn(FAST);
        when(characterMove.getDamage()).thenReturn(characterMoveDamage);

        when(targetMove.getSpeed()).thenReturn(FAST);
        when(targetMove.getDamage()).thenReturn(targetMoveDamage);
        when(targetMove.getShield()).thenReturn(targetMoveShield);

        executor.execute(characterMove, targetMove);

        verify(target).receiveDamage(characterMoveDamage - targetMoveDamage - targetMoveShield);
    }

    @Test
    void when_execute_given_characterMove_is_slower_than_targetMove_and_both_moves_have_damage_should_do_nothing() {
        when(characterMove.getSpeed()).thenReturn(SLOW);
        when(characterMove.getDamage()).thenReturn(1.0);

        when(targetMove.getSpeed()).thenReturn(FAST);
        when(targetMove.getDamage()).thenReturn(1.0);

        executor.execute(characterMove, targetMove);

        verify(target, never()).receiveDamage(anyDouble());
    }

    @Test
    void when_execute_given_characterMove_is_slower_than_targetMove_and_only_characterMove_has_damage_should_perform_character_move_considering_targetMove_shield() {
        when(characterMove.getSpeed()).thenReturn(SLOW);
        when(characterMove.getDamage()).thenReturn(10.0);

        when(targetMove.getSpeed()).thenReturn(FAST);
        when(targetMove.getDamage()).thenReturn(0.0);
        when(targetMove.getShield()).thenReturn(6.0);

        executor.execute(characterMove, targetMove);

        verify(target).receiveDamage(4.0);
    }
}