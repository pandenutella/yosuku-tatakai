package com.pandenutella.yt.combos;

import com.pandenutella.yt.core.Combo;
import com.pandenutella.yt.core.Move;
import com.pandenutella.yt.core.moves.Dodge;
import com.pandenutella.yt.core.moves.Focus;
import com.pandenutella.yt.core.moves.Uppercut;

import java.util.List;

import static java.util.Arrays.asList;

public class SampleComboTwo implements Combo {
    @Override
    public List<Move> getMoveList() {
        return asList(new Dodge(), new Focus(), new Uppercut());
    }
}
