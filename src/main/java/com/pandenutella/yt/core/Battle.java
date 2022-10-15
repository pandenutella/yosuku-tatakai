package com.pandenutella.yt.core;

import com.pandenutella.yt.core.exceptions.AllowedRepeatedMovesExceededException;
import com.pandenutella.yt.core.exceptions.GameOverException;
import com.pandenutella.yt.core.exceptions.InvalidNumberOfMovesInComboException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Battle {

    private final GameCharacter character1;
    private final GameCharacter character2;

    private final Printer printer;
    private final Clock clock;

    public void fight() throws InvalidNumberOfMovesInComboException, AllowedRepeatedMovesExceededException {
        int movesPerCombo = 3;

        printer.printLine("------------------------");
        printer.printLine("%s vs %s".formatted(character1.getName(), character2.getName()));
        printer.printLine("------------------------");
        clock.pauseFor(4);

        try {
            for (int round = 1; round <= 10; round++) {
                if (round > 1) printer.printLine("------------------------");
                printer.printRound(round);

                GameCharacter attacker = round % 2 == 1 ? character1 : character2;
                GameCharacter defender = round % 2 == 1 ? character2 : character1;

                Combo attackerCombo = attacker.initiateAttack();
                Combo defenderCombo = defender.formulateCounter(attackerCombo.getMoveList().get(0));

                attackerCombo.validate();
                defenderCombo.validate();

                CharacterMoveExecutor attackerExecutor = new CharacterMoveExecutor(round % 2 == 1 ? character2 : character1);
                CharacterMoveExecutor defenderExecutor = new CharacterMoveExecutor(round % 2 == 1 ? character1 : character2);

                printer.printCharacterCombo(attacker, attackerCombo);
                printer.printCharacterCombo(defender, defenderCombo);

                for (int i = 0; i < movesPerCombo; i++) {
                    Move attackerMove = attackerCombo.getMoveList().get(i);
                    Move defenderMove = defenderCombo.getMoveList().get(i);

                    attackerExecutor.execute(attackerMove, defenderMove);
                    defenderExecutor.execute(defenderMove, attackerMove);

                    if (attacker.getHP() <= 0 && defender.getHP() <= 0)
                        throw new GameOverException(null);
                    else if (defender.getHP() == 0)
                        throw new GameOverException(attacker.getName());
                    else if (attacker.getHP() == 0)
                        throw new GameOverException(defender.getName());
                }

                attacker.observeEnemyCounter(defenderCombo.getMoveList());

                printer.printCharacterStatuses(character1, character2);
                clock.pauseFor(1);
            }

            if (character1.getHP() > character2.getHP())
                throw new GameOverException(character1.getName());
            else if (character2.getHP() > character1.getHP())
                throw new GameOverException(character2.getName());
            else
                throw new GameOverException(null);
        } catch (GameOverException e) {
            printer.printLine("------------------------");
            printer.printLine(e.getMessage());
            printer.printLine("------------------------");
        }
    }
}
