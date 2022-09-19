package com.pandenutella.yt.core.printers;

import com.pandenutella.yt.core.Combo;
import com.pandenutella.yt.core.ConsoleColors;
import com.pandenutella.yt.core.GameCharacter;
import com.pandenutella.yt.core.Move;
import com.pandenutella.yt.core.Printer;

import static com.pandenutella.yt.core.ConsoleColorUtility.colorBy;
import static com.pandenutella.yt.core.ConsoleColors.BLUE_BOLD;
import static com.pandenutella.yt.core.ConsoleColors.GREEN;
import static com.pandenutella.yt.core.ConsoleColors.GREEN_BACKGROUND;
import static com.pandenutella.yt.core.ConsoleColors.RED;
import static com.pandenutella.yt.core.ConsoleColors.RED_BACKGROUND;
import static com.pandenutella.yt.core.ConsoleColors.YELLOW;
import static com.pandenutella.yt.core.ConsoleColors.YELLOW_BACKGROUND;
import static com.pandenutella.yt.core.ConsoleColors.YELLOW_BOLD;
import static java.util.stream.Collectors.joining;

public class ActualPrinter implements Printer {

    @Override
    public void printLine(String message) {
        System.out.println(message);
    }

    @Override
    public void printRound(int round) {
        printLine("%s %d".formatted(colorBy("ROUND", BLUE_BOLD), round));
    }

    @Override
    public void printCharacterStatuses(GameCharacter character1, GameCharacter character2) {
        String character1HPBar = getHPBar(character1, false);
        String character2HPBar = getHPBar(character2, true);

        printLine("%s%s".formatted(character1HPBar, character2HPBar));
    }

    @Override
    public void printCharacterCombo(GameCharacter character, Combo combo) {
        String comboString = combo.getMoveList().stream()
                .map(Move::getName)
                .collect(joining(" > "));

        printLine("%s: %s"
                .formatted(
                        colorBy(character.getName(), YELLOW_BOLD),
                        comboString
                )
        );
    }

    private String getHPBar(GameCharacter character, boolean inverted) {
        int bars = 10;
        int hpPerBar = (int) (character.getMaxHP() / bars);

        ConsoleColors barColor;
        ConsoleColors barOutlineColor;
        if (character.getHP() > 66) {
            barColor = GREEN_BACKGROUND;
            barOutlineColor = GREEN;
        } else if (character.getHP() > 33) {
            barColor = YELLOW_BACKGROUND;
            barOutlineColor = YELLOW;
        } else {
            barColor = RED_BACKGROUND;
            barOutlineColor = RED;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(colorBy("[", barOutlineColor));
        for (int i = 0; i < bars; i++) {
            boolean isHP = character.getHP() / hpPerBar > (inverted ? bars - i - 1 : i);

            stringBuilder.append(isHP
                    ? colorBy(" ", barColor)
                    : " ");
        }
        stringBuilder.append(colorBy("]", barOutlineColor));

        return stringBuilder.toString();
    }
}
