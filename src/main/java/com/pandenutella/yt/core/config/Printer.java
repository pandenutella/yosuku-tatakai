package com.pandenutella.yt.core.config;

import com.pandenutella.yt.core.Combo;
import com.pandenutella.yt.core.GameCharacter;

public interface Printer {
    void printLine(String message);

    void printRound(int round);

    void printCharacterStatuses(GameCharacter character1, GameCharacter character2);

    void printCharacterCombo(GameCharacter character, Combo combo);
}
