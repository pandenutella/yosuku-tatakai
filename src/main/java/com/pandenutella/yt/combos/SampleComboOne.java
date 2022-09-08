package com.pandenutella.yt.combos;

import com.pandenutella.yt.core.Combo;
import com.pandenutella.yt.core.Move;
import com.pandenutella.yt.core.moves.Block;
import com.pandenutella.yt.core.moves.Jab;
import com.pandenutella.yt.core.moves.Straight;

import java.util.List;

import static java.util.Arrays.asList;

public class SampleComboOne implements Combo {
    @Override
    public List<Move> getMoveList() {
        return asList(new Block(), new Jab(), new Straight());
    }
}
