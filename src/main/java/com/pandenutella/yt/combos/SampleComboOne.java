package com.pandenutella.yt.combos;

import com.pandenutella.yt.core.Combo;

import java.util.List;

import static java.util.Arrays.asList;

public class SampleComboOne implements Combo {
    @Override
    public List<String> getMoveList() {
        return asList("block", "jab", "straight");
    }
}
