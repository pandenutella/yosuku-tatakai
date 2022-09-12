package com.pandenutella.yt.mages;

import com.pandenutella.yt.core.Mage;

import java.util.Random;

public class SampleMageOne extends Mage {

    private final Random random = new Random();

    @Override
    public String getName() {
        return "SM1";
    }

    @Override
    protected String attack(double life, double mana, double enemyLife, double enemyMana) {
        int offenseVariation = random.nextInt(3);

        return switch (offenseVariation) {
            case 0 -> "223";
            case 1 -> "322";
            case 2 -> "070";
            default -> null;
        };
    }

    @Override
    protected String defend(double life, double mana, double enemyLife, double enemyMana, int enemyTotalManaSpent) {
        int defenseVariation = random.nextInt(3);

        return switch (defenseVariation) {
            case 0 -> "223";
            case 1 -> "322";
            case 2 -> "070";
            default -> null;
        };
    }
}
