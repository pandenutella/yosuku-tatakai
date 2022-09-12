package com.pandenutella.yt.mages;

import com.pandenutella.yt.core.Mage;

public class SampleMageTwo extends Mage {
    @Override
    public String getName() {
        return "SM2";
    }

    @Override
    protected String attack(double enemyLife, double enemyMana) {
        return "333";
    }

    @Override
    protected String defend(double life, double mana, double enemyMana, int enemyTotalManaSpent) {
        return "333";
    }
}
