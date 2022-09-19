package com.pandenutella.yt.core;

public interface Printer {
    void printLine(String message);

    void printCharacterStatuses(GameCharacter character1, GameCharacter character2);

    void printCharacterCombo(GameCharacter character, Combo combo);
}
