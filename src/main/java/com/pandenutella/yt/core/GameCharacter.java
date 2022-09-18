package com.pandenutella.yt.core;

public interface GameCharacter {
    Combo initiateAttack();

    Combo formulateCounter();

    void receiveDamage(double damage);

    double getHP();

    double getMaxHP();
}
