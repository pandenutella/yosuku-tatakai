package com.pandenutella.yt.core.config.printers;

import com.pandenutella.yt.core.Mage;
import com.pandenutella.yt.core.config.Printer;

import java.util.List;

public class SimulationPrinter implements Printer {
    @Override
    public void printThickLine() {
    }

    @Override
    public void printThinLine() {
    }

    @Override
    public void printRoundHeader(int round, String attackerName, String defenderName) {
    }

    @Override
    public void printMoveHeader(int moveNumber) {
    }

    @Override
    public void printResults(String winner) {
    }

    @Override
    public void printStatus(List<Mage> mageList) {
    }

    @Override
    public void printSpellUsed(String attacker, String move, String defender, String otherDescription) {
    }
}
