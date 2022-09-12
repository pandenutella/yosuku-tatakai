package com.pandenutella.yt.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static java.lang.Math.max;
import static java.lang.Math.min;

@RequiredArgsConstructor
@Getter
public abstract class Mage {

    private final double maxLife = 7;
    private final double maxMana = 7;

    private double life = maxLife;
    private double mana = maxMana / 2;

    public abstract String getName();

    protected abstract String attack(double enemyLife, double enemyMana);

    protected abstract String defend(double life, double mana, double enemyMana, int enemyTotalManaSpent);

    public void burnMana(double points) {
        mana = max(mana - points, 0);
    }

    public void receiveDamage(double damage) {
        life = max(life - damage, 0);
    }

    public void regenerateLife(double points) {
        life = min(life + points, maxLife);
    }

    public void regenerateMana(double points) {
        mana = min(mana + points, maxMana);
    }
}
