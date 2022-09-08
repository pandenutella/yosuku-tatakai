package com.pandenutella.yt.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
public abstract class Fighter {

    @Getter
    private final double maxLife = 100;

    @Getter
    private double life = maxLife;

    @Getter
    @Setter
    private double shield = 0;

    @Getter
    @Setter
    private boolean nimble = false;

    @Getter
    @Setter
    private double damageMultiplier = 1;

    public abstract String getName();

    protected abstract Combo executeCombo(double life, double enemyLife);

    protected abstract Combo executeCounterCombo(double life, double enemyLife, List<Move> enemyMoveList);

    public double dealDamage(double damage) {
        double dealtDamage = damage * damageMultiplier;
        damageMultiplier = 1;

        return dealtDamage;
    }

    public double receiveDamage(double damage) {
        if (nimble)
            return 0;

        double receivedDamage = shield <= damage
                ? damage - shield
                : 0;

        shield = shield > damage
                ? shield - damage
                : 0;

        if (receivedDamage > life) {
            life = 0;
            return receivedDamage - life;
        }

        life -= receivedDamage;
        return receivedDamage;
    }

    public void heal(double points) {
        life = life + points < 100
                ? life + points
                : 100;
    }
}
