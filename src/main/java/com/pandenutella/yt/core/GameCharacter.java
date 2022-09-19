package com.pandenutella.yt.core;

import java.util.List;

public interface GameCharacter {
    String getName();

    Combo initiateAttack();

    Combo formulateCounter(Move firstMove);

    void observeEnemyCounter(List<Move> moveList);

    void receiveDamage(double damage);

    double getHP();

    double getMaxHP();
}
