package com.pandenutella.yt.core.config.printers;

import com.pandenutella.yt.core.Mage;
import com.pandenutella.yt.core.config.Printer;

import java.util.List;

import static com.pandenutella.yt.core.enums.Color.BOLD_BLUE;
import static com.pandenutella.yt.core.enums.Color.BOLD_GREEN;
import static com.pandenutella.yt.core.enums.Color.BOLD_YELLOW;
import static com.pandenutella.yt.core.utilities.ColorUtility.colorTextWith;
import static java.lang.String.valueOf;
import static java.util.Objects.isNull;

public class ActualPrinter implements Printer {
    @Override
    public void printThickLine() {
        System.out.println("======================================================================");
    }

    @Override
    public void printThinLine() {
        System.out.println("----------------------------------------------------------------------");
    }

    @Override
    public void printRoundHeader(int round, String attackerName, String defenderName) {
        if (round == 1) printThickLine();
        System.out.printf("%s %s will be attacking %s...%n",
                colorTextWith("[ROUND %d]".formatted(round), BOLD_BLUE),
                colorTextWith(attackerName, BOLD_YELLOW),
                colorTextWith(defenderName, BOLD_YELLOW));
        printThickLine();
    }

    @Override
    public void printMoveHeader(int moveNumber) {
        if (moveNumber > 1) printThinLine();
        System.out.println(colorTextWith("[MOVE %d]".formatted(moveNumber), BOLD_BLUE));
    }

    @Override
    public void printResults(String winner) {
        printThickLine();

        if (isNull(winner))
            System.out.println("The battle ended with a tie!");
        else
            System.out.printf("The battle ended in favor of %s!%n",
                    colorTextWith(winner, BOLD_YELLOW));

        printThickLine();
    }

    @Override
    public void printStatus(List<Mage> mageList) {
        printThickLine();
        System.out.println(colorTextWith("[STATUS]", BOLD_BLUE));

        mageList.forEach(mage -> {
            System.out.printf("%s has [%s/%s HP] [%s/%s MP]%n",
                    colorTextWith(mage.getName(), BOLD_YELLOW),
                    colorTextWith(valueOf(mage.getLife()), BOLD_GREEN),
                    colorTextWith(valueOf(mage.getMaxLife()), BOLD_GREEN),
                    colorTextWith(valueOf(mage.getMana()), BOLD_BLUE),
                    colorTextWith(valueOf(mage.getMaxMana()), BOLD_BLUE));
        });
        printThickLine();
    }

    @Override
    public void printSpellUsed(String caster, String move, String target, String otherDescription) {
        System.out.printf("%s used %s%s, %s.%n",
                colorTextWith(caster, BOLD_YELLOW),
                colorTextWith(move, BOLD_YELLOW),
                isNull(target) ? "" : " against %s".formatted(colorTextWith(target, BOLD_YELLOW)),
                otherDescription);
    }
}
