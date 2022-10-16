package com.pandenutella.yt.core;

import com.pandenutella.yt.core.exceptions.AllowedRepeatedMovesExceededException;
import com.pandenutella.yt.core.exceptions.GameOverException;
import com.pandenutella.yt.core.exceptions.InvalidNumberOfMovesInComboException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Battle {

    private final GameCharacter character1;
    private final GameCharacter character2;

    private final Config config;

    public void fight() throws InvalidNumberOfMovesInComboException, AllowedRepeatedMovesExceededException {
        int movesPerCombo = 3;

        config.getPrinter().printLine("------------------------");
        config.getPrinter().printLine("%s vs %s".formatted(character1.getName(), character2.getName()));
        config.getPrinter().printLine("------------------------");
        config.getClock().pauseFor(4);

        try {
            for (int round = 1; round <= 10; round++) {
                if (round > 1) config.getPrinter().printLine("------------------------");
                config.getPrinter().printRound(round);

                GameCharacter attacker = round % 2 == 1 ? character1 : character2;
                GameCharacter defender = round % 2 == 1 ? character2 : character1;

                Combo attackerCombo = attacker.initiateAttack();
                Combo defenderCombo = defender.formulateCounter(attackerCombo.getMoveList().get(0));

                attackerCombo.validate();
                defenderCombo.validate();

                CharacterMoveExecutor attackerExecutor = new CharacterMoveExecutor(round % 2 == 1 ? character2 : character1);
                CharacterMoveExecutor defenderExecutor = new CharacterMoveExecutor(round % 2 == 1 ? character1 : character2);

                config.getPrinter().printCharacterCombo(attacker, attackerCombo);
                config.getPrinter().printCharacterCombo(defender, defenderCombo);

                for (int i = 0; i < movesPerCombo; i++) {
                    Move attackerMove = attackerCombo.getMoveList().get(i);
                    Move defenderMove = defenderCombo.getMoveList().get(i);

                    String attackMovePrintedString = attackerExecutor.execute(attackerMove, defenderMove);
                    String counterMovePrintedString = defenderExecutor.execute(defenderMove, attackerMove);

                    String character1MovePrintedString = round % 2 != 0 ? attackMovePrintedString : counterMovePrintedString;
                    String character2MovePrintedString = round % 2 == 0 ? attackMovePrintedString : counterMovePrintedString;

                    config.getPrinter().printCharacterStatuses(character1, character2);
                    config.getPrinter().printLine(character1MovePrintedString + config.getStringUtility().flip(character2MovePrintedString));

                    if (attacker.getHP() <= 0 && defender.getHP() <= 0)
                        throw new GameOverException(null);
                    else if (defender.getHP() == 0)
                        throw new GameOverException(attacker.getName());
                    else if (attacker.getHP() == 0)
                        throw new GameOverException(defender.getName());
                }

                attacker.observeEnemyCounter(defenderCombo.getMoveList());

                config.getClock().pauseFor(1);
            }

            if (character1.getHP() > character2.getHP())
                throw new GameOverException(character1.getName());
            else if (character2.getHP() > character1.getHP())
                throw new GameOverException(character2.getName());
            else
                throw new GameOverException(null);
        } catch (GameOverException e) {
            config.getPrinter().printLine("------------------------");
            config.getPrinter().printLine(e.getMessage());
            config.getPrinter().printLine("------------------------");
        }
    }
}
