package com.pandenutella.yt.core.config;

import com.pandenutella.yt.core.Fighter;

public interface Printer {
    void printThickLine();

    void printThinLine();

    void printRoundHeader(int round, String attackerName, String defenderName);

    void printMoveHeader(int moveNumber);

    void printResults(String winner);

    void printStatus(Fighter fighterOne, Fighter fighterTwo);

    void printMoveUsed(String attacker, String move, String defender, String otherDescription);
}
