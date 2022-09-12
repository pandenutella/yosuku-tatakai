package com.pandenutella.yt.core;

import com.pandenutella.yt.core.exceptions.MageDefeatedException;
import com.pandenutella.yt.core.utilities.ManaCostConverter;
import lombok.RequiredArgsConstructor;

import static com.pandenutella.yt.core.enums.Color.BOLD_BLUE;
import static com.pandenutella.yt.core.enums.Color.BOLD_RED;
import static com.pandenutella.yt.core.utilities.ColorUtility.colorTextWith;
import static java.lang.Math.max;
import static java.lang.String.valueOf;
import static java.util.Arrays.asList;

@RequiredArgsConstructor
public class Battle {
    private final Mage mageOne;
    private final Mage mageTwo;
    private final Utility utility;
    private final int spellsPerRound;
    private final ManaCostConverter manaCostConverter;

    public void start() {
        try {
            for (int round = 1; round <= 7; round++) {
                Mage attacker = round % 2 == 1 ? mageOne : mageTwo;
                Mage defender = round % 2 == 1 ? mageTwo : mageOne;

                utility.getPrinter().printRoundHeader(round, attacker.getName(), defender.getName());
                utility.getClock().waitFor(2);

                String offenseManaCostsRaw = attacker.attack(attacker.getLife(), defender.getLife());
                int[] offenseManaCosts = manaCostConverter.getManaCosts(offenseManaCostsRaw, spellsPerRound);
                int totalOffenseManaCost = manaCostConverter.getTotalManaCost(offenseManaCostsRaw, spellsPerRound);

                String defenseManaCostRaw = defender.defend(defender.getLife(), defender.getMana(), attacker.getMana(), totalOffenseManaCost);
                int[] defenseManaCosts = manaCostConverter.getManaCosts(defenseManaCostRaw, spellsPerRound);

                for (int spellIndex = 0; spellIndex < spellsPerRound; spellIndex++) {
                    utility.getPrinter().printMoveHeader(spellIndex + 1);
                    utility.getClock().waitFor(.5);

                    int defenseManaCost = defenseManaCosts[spellIndex];
                    int offenseManaCost = offenseManaCosts[spellIndex];

                    if (defenseManaCost == 0) {
                        defender.regenerateMana(1);
                        utility.getPrinter().printSpellUsed(defender.getName(), "Meditate", null,
                                "generating %s mana".formatted(colorTextWith(valueOf(1), BOLD_BLUE)));
                    } else if (defenseManaCost <= defender.getMana()) {
                        defender.burnMana(defenseManaCost);
                        utility.getPrinter().printSpellUsed(defender.getName(), "Mana Shield (Tier %d)".formatted(defenseManaCost), null,
                                "blocking up to %s damage".formatted(colorTextWith(valueOf(defenseManaCost), BOLD_RED)));
                    } else {
                        double bouncedMana = defenseManaCost - defender.getMana();
                        defender.receiveDamage(bouncedMana);
                        defender.burnMana(defenseManaCost);

                        utility.getPrinter().printSpellUsed(defender.getName(), "Defective Mana Shield (Tier %d)".formatted(defenseManaCost), null,
                                "causing surrounding mana to explode and receive %s damage".formatted(colorTextWith(valueOf(bouncedMana), BOLD_RED)));

                        checkIfAlreadyDefeated(defender);
                    }

                    utility.getClock().waitFor(.5);

                    if (offenseManaCost == 0) {
                        attacker.regenerateMana(1);
                        utility.getPrinter().printSpellUsed(attacker.getName(), "Meditate", null,
                                "generating %s mana".formatted(colorTextWith(valueOf(1), BOLD_BLUE)));
                    } else if(offenseManaCost <= attacker.getMana()) {
                        attacker.burnMana(offenseManaCost);
                        double damageDealt = max(offenseManaCost - defenseManaCost, 0);
                        defender.receiveDamage(damageDealt);
                        utility.getPrinter().printSpellUsed(attacker.getName(), "Mana Blast (Tier %d)".formatted(offenseManaCost), defender.getName(),
                                "dealing %s damage".formatted(colorTextWith(valueOf(damageDealt), BOLD_RED)));

                        checkIfAlreadyDefeated(defender);
                    } else {
                        double bouncedMana = offenseManaCost - attacker.getMana();
                        attacker.receiveDamage(bouncedMana);
                        attacker.burnMana(offenseManaCost);

                        utility.getPrinter().printSpellUsed(attacker.getName(), "Defective Mana Burst (Tier %d)".formatted(offenseManaCost), null,
                                "causing surrounding mana to explode and receive %s damage".formatted(colorTextWith(valueOf(bouncedMana), BOLD_RED)));

                        checkIfAlreadyDefeated(attacker);
                    }

                    utility.getClock().waitFor(2);
                }

                attacker.regenerateMana(1);
                defender.regenerateMana(1);

                utility.getPrinter().printStatus(asList(mageOne, mageTwo));
                utility.getClock().waitFor(4);
            }
        } catch (MageDefeatedException ignored) {
        }

        finalizeResults();
    }

    private void checkIfAlreadyDefeated(Mage mage) throws MageDefeatedException {
        if (mage.getLife() > 0)
            return;

        throw new MageDefeatedException();
    }

    private void finalizeResults() {
        String winner;
        if (mageTwo.getLife() == 0)
            winner = mageOne.getName();
        else if (mageOne.getLife() == 0)
            winner = mageTwo.getName();
        else
            winner = null;

        utility.getPrinter().printResults(winner);
    }
}
