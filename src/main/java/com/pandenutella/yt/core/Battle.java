package com.pandenutella.yt.core;

import com.pandenutella.yt.core.exceptions.FighterDefeatedException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static com.pandenutella.yt.core.utilities.SpeedChecker.isSpeedFaster;
import static java.util.Arrays.asList;

@RequiredArgsConstructor
public class Battle {
    private final Fighter fighterOne;
    private final Fighter fighterTwo;
    private final MoveFactory moveFactory;
    private final Utility utility;

    public void start() {
        try {
            for (int round = 1; round <= 10; round++) {
                Fighter attacker = round % 2 == 1 ? fighterOne : fighterTwo;
                Fighter defender = round % 2 == 1 ? fighterTwo : fighterOne;

                utility.getPrinter().printRoundHeader(round, attacker.getName(), defender.getName());
                utility.getClock().waitFor(2);

                Combo combo = attacker.executeCombo(attacker.getLife(), defender.getLife());

                List<Move> comboMoveList = combo.getMoveList().stream()
                        .map(moveFactory::getMove)
                        .collect(Collectors.toList());
                Combo counterCombo = defender.executeCounterCombo(defender.getLife(), attacker.getLife(), comboMoveList);

                for (int moveNumber = 1; moveNumber <= 3; moveNumber++) {
                    utility.getPrinter().printMoveHeader(moveNumber);
                    utility.getClock().waitFor(.5);

                    Move move = moveFactory.getMove(combo.getMoveList().get(moveNumber - 1));
                    Move counterMove = moveFactory.getMove(counterCombo.getMoveList().get(moveNumber - 1));

                    if (isSpeedFaster(move.getSpeed(), counterMove.getSpeed())) {
                        move.perform(attacker, defender);
                        checkIfAlreadyDefeated(defender);

                        utility.getClock().waitFor(.5);

                        counterMove.perform(defender, attacker);
                        checkIfAlreadyDefeated(attacker);
                    } else {
                        counterMove.perform(defender, attacker);
                        checkIfAlreadyDefeated(attacker);

                        utility.getClock().waitFor(.5);

                        move.perform(attacker, defender);
                        checkIfAlreadyDefeated(defender);
                    }

                    attacker.setNimble(false);
                    defender.setNimble(false);

                    utility.getClock().waitFor(2);
                }

                attacker.setShield(0);
                defender.setShield(0);

                attacker.setDamageMultiplier(1);
                defender.setDamageMultiplier(1);

                attacker.heal(2.5);
                defender.heal(2.5);

                utility.getPrinter().printStatus(asList(fighterOne, fighterTwo));
                utility.getClock().waitFor(4);
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

        utility.getPrinter().printResults(winner);
    }
}
