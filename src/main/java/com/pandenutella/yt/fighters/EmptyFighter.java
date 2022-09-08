package com.pandenutella.yt.fighters;

import com.pandenutella.yt.core.Combo;
import com.pandenutella.yt.core.Fighter;
import com.pandenutella.yt.core.Move;

import java.util.List;

public class EmptyFighter extends Fighter {
//    TODO: Create your own fighter by copying this class

    @Override
    public String getName() {
//        TODO: Provide the name of your fighter
        return null;
    }

    @Override
    protected Combo executeCombo(double life, double enemyLife) {
//        TODO: Write algorithm on what combo to use for attacking
        return null;
    }

    @Override
    protected Combo executeCounterCombo(double life, double enemyLife, List<Move> enemyMoveList) {
//        TODO: Write algorithm on what combo to use for defending
        return null;
    }
}
