package com.pandenutella.yt.core;

import com.pandenutella.yt.core.exceptions.FighterDefeatedException;
import lombok.RequiredArgsConstructor;

import static com.pandenutella.yt.core.utilities.BattleUtility.displayMoveHeader;
import static com.pandenutella.yt.core.utilities.BattleUtility.displayResults;
import static com.pandenutella.yt.core.utilities.BattleUtility.displayRoundHeader;
import static com.pandenutella.yt.core.utilities.BattleUtility.displayStatus;
import static com.pandenutella.yt.core.utilities.BattleUtility.waitSeconds;
import static com.pandenutella.yt.core.utilities.SpeedChecker.isSpeedFaster;

@RequiredArgsConstructor
public class Battle {
    private final Fighter fighterOne;
    private final Fighter fighterTwo;

    public void start() {
        try {
            for (int round = 1; round <= 10; round++) {
                Fighter attacker = round % 2 == 1 ? fighterOne : fighterTwo;
                Fighter defender = round % 2 == 1 ? fighterTwo : fighterOne;

                displayRoundHeader(round, attacker.getName(), defender.getName());
                waitSeconds(2);

                Combo combo = attacker.executeCombo(attacker.getLife(), defender.getLife());
                Combo counterCombo = defender.executeCounterCombo(defender.getLife(), attacker.getLife(), combo.getMoveList());

                for (int moveNumber = 1; moveNumber <= 3; moveNumber++) {
                    displayMoveHeader(moveNumber);
                    waitSeconds(.5);

                    Move move = combo.getMoveList().get(moveNumber - 1);
                    Move counterMove = counterCombo.getMoveList().get(moveNumber - 1);

                    if (isSpeedFaster(move.getSpeed(), counterMove.getSpeed())) {
                        move.perform(attacker, defender);
                        checkIfAlreadyDefeated(defender);

                        waitSeconds(.5);

                        counterMove.perform(defender, attacker);
                        checkIfAlreadyDefeated(attacker);
                    } else {
                        counterMove.perform(defender, attacker);
                        checkIfAlreadyDefeated(attacker);

                        waitSeconds(.5);

                        move.perform(attacker, defender);
                        checkIfAlreadyDefeated(defender);
                    }

                    attacker.setNimble(false);
                    defender.setNimble(false);

                    waitSeconds(2);
                }

                attacker.setShield(0);
                defender.setShield(0);

                attacker.setDamageMultiplier(1);
                defender.setDamageMultiplier(1);

                attacker.heal(2.5);
                defender.heal(2.5);

                displayStatus(fighterOne, fighterTwo);

                waitSeconds(4);
            }
        } catch (FighterDefeatedException ignored) {
        }

        finalizeResults();
    }

    private void checkIfAlreadyDefeated(Fighter fighter) throws FighterDefeatedException {
        if (fighter.getLife() > 0)
            return;

        throw new FighterDefeatedException();
    }

    private void finalizeResults() {
        String winner;
        if (fighterTwo.getLife() == 0)
            winner = fighterOne.getName();
        else if (fighterOne.getLife() == 0)
            winner = fighterTwo.getName();
        else
            winner = null;

        displayResults(winner);
    }
}
