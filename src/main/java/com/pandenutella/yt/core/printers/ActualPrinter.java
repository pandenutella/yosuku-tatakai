package com.pandenutella.yt.core.printers;

import com.pandenutella.yt.core.Combo;
import com.pandenutella.yt.core.GameCharacter;
import com.pandenutella.yt.core.Move;
import com.pandenutella.yt.core.Printer;

import static java.util.stream.Collectors.joining;

public class ActualPrinter implements Printer {

    @Override
    public void printLine(String message) {
        System.out.println(message);
    }

    @Override
    public void printCharacterStatuses(GameCharacter character1, GameCharacter character2) {
        String character1HPBar = getHPBar(character1, false);
        String character2HPBar = getHPBar(character2, true);

        printLine("[%s][%s]".formatted(character1HPBar, character2HPBar));
    }

    @Override
    public void printCharacterCombo(GameCharacter character, Combo combo) {
        String comboString = combo.getMoveList().stream()
                .map(Move::getName)
                .collect(joining(" > "));

        printLine("%s: %s".formatted(character.getName(), comboString));
    }

    private String getHPBar(GameCharacter character, boolean inverted) {
        int bars = 10;
        int hpPerBar = (int) (character.getMaxHP() / bars);

        char barCharacter = inverted ? '<' : '>';

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bars; i++) {
            boolean isHP = character.getHP() / hpPerBar > (inverted ? bars - i - 1 : i);

            stringBuilder.append(isHP ? barCharacter : " ");
        }

        return stringBuilder.toString();
    }
}
