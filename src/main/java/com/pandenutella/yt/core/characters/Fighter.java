package com.pandenutella.yt.core.characters;

import com.pandenutella.yt.core.GameCharacter;

import static java.lang.Math.max;

public abstract class Fighter implements GameCharacter {

    private final double MAX_HP = 100;
    private double hp = MAX_HP;

    @Override
    public void receiveDamage(double damage) {
        hp = max(hp - damage, 0);
    }

    @Override
    public double getHP() {
        return hp;
    }

    @Override
    public double getMaxHP() {
        return MAX_HP;
    }
}
