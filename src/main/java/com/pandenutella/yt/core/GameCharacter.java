package com.pandenutella.yt.core;

public interface GameCharacter {
    String getName();

    Combo initiateAttack();

    Combo formulateCounter();

    void receiveDamage(double damage);

    double getHP();

    double getMaxHP();
}
