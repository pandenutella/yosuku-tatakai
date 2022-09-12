package com.pandenutella.yt.core.config;

import com.pandenutella.yt.core.Mage;

import java.util.List;

public interface Printer {
    void printThickLine();

    void printThinLine();

    void printRoundHeader(int round, String attackerName, String defenderName);

    void printMoveHeader(int moveNumber);

    void printResults(String winner);

    void printStatus(List<Mage> mageList);

    void printSpellUsed(String caster, String move, String target, String otherDescription);
}
