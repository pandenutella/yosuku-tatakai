package com.pandenutella.yt.core.utilities;

import com.pandenutella.yt.core.Fighter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import static com.pandenutella.yt.core.enums.Color.BOLD_BLUE;
import static com.pandenutella.yt.core.enums.Color.BOLD_GREEN;
import static com.pandenutella.yt.core.enums.Color.BOLD_YELLOW;
import static com.pandenutella.yt.core.utilities.ColorUtility.colorTextWith;
import static java.lang.String.valueOf;
import static java.lang.Thread.sleep;
import static java.util.Objects.isNull;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class BattleUtility {

    private static void displayThickLine() {
        System.out.println("======================================================================");
    }

    private static void displayThinLine() {
        System.out.println("----------------------------------------------------------------------");
    }

    public static void displayRoundHeader(int round, String attackerName, String defenderName) {
        if (round == 1) displayThickLine();
        System.out.printf("%s %s will be attacking %s...%n",
                colorTextWith("[ROUND %d]".formatted(round), BOLD_BLUE),
                colorTextWith(attackerName, BOLD_YELLOW),
                colorTextWith(defenderName, BOLD_YELLOW));
        displayThickLine();
    }

    public static void displayMoveHeader(int moveNumber) {
        if (moveNumber > 1) displayThinLine();
        System.out.println(colorTextWith("[MOVE %d]".formatted(moveNumber), BOLD_BLUE));
    }

    public static void displayResults(String winner) {
        displayThickLine();

        if (isNull(winner))
            System.out.println("The battle ended with a tie!");
        else
            System.out.printf("The battle ended in favor of %s!%n",
                    colorTextWith(winner, BOLD_YELLOW));

        displayThickLine();
    }

    public static void displayStatus(Fighter fighterOne, Fighter fighterTwo) {
        displayThickLine();
        System.out.println(colorTextWith("[STATUS]", BOLD_BLUE));

        System.out.printf("%s has %s/%s HP%n",
                colorTextWith(fighterOne.getName(), BOLD_YELLOW),
                colorTextWith(valueOf(fighterOne.getLife()), BOLD_GREEN),
                colorTextWith(valueOf(fighterOne.getMaxLife()), BOLD_GREEN));
        System.out.printf("%s has %s/%s HP%n",
                colorTextWith(fighterTwo.getName(), BOLD_YELLOW),
                colorTextWith(valueOf(fighterTwo.getLife()), BOLD_GREEN),
                colorTextWith(valueOf(fighterTwo.getMaxLife()), BOLD_GREEN));

        displayThickLine();
    }

    public static void displayMoveUsed(String attacker, String move, String defender, String otherDescription) {
        System.out.printf("%s used %s%s, %s.%n",
                colorTextWith(attacker, BOLD_YELLOW),
                colorTextWith(move, BOLD_YELLOW),
                isNull(defender) ? "" : " against %s".formatted(colorTextWith(defender, BOLD_YELLOW)),
                otherDescription);
    }

    @SneakyThrows
    public static void waitSeconds(double seconds) {
        sleep((long) (1000 * seconds));
    }
}
