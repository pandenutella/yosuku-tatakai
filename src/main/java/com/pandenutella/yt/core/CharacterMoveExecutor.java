package com.pandenutella.yt.core;

import lombok.RequiredArgsConstructor;

import static java.lang.Math.max;

@RequiredArgsConstructor
public class CharacterMoveExecutor {
    private final GameCharacter target;

    public void execute(Move characterMove, Move targetMove) {
        int characterMoveSpeed = characterMove.getSpeed().ordinal();
        int targetMoveSpeed = targetMove.getSpeed().ordinal();

        if (characterMoveSpeed < targetMoveSpeed && characterMove.getDamage() > 0 && targetMove.getDamage() > 0)
            return;

        double damageDealt = characterMoveSpeed == targetMoveSpeed
                ? max(characterMove.getDamage() - targetMove.getDamage() - targetMove.getShield(), 0)
                : max(characterMove.getDamage() - targetMove.getShield(), 0);

        target.receiveDamage(damageDealt);
    }
}
