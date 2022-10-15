package com.pandenutella.yt.custom.characters;

import com.pandenutella.yt.core.Combo;
import com.pandenutella.yt.core.Move;
import com.pandenutella.yt.core.characters.Fighter;

import java.util.List;

public class EmptyFighter extends Fighter {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Combo initiateAttack() {
        return null;
    }

    @Override
    public Combo formulateCounter(Move firstMove) {
        return null;
    }

    @Override
    public void observeEnemyCounter(List<Move> moveList) {
    }
}
