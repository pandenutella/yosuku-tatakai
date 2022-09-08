package com.pandenutella.yt.combos;

import com.pandenutella.yt.core.Combo;
import com.pandenutella.yt.core.Move;
import com.pandenutella.yt.core.moves.Jab;
import com.pandenutella.yt.core.moves.Straight;
import com.pandenutella.yt.core.moves.Uppercut;

import java.util.List;

import static java.util.Arrays.asList;

public class SampleComboThree implements Combo {
    @Override
    public List<Move> getMoveList() {
        return asList(new Uppercut(), new Straight(), new Jab());
    }
}
