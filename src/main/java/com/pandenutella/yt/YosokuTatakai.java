package com.pandenutella.yt;

import com.pandenutella.yt.core.Battle;
import com.pandenutella.yt.fighters.SampleFighterOne;
import com.pandenutella.yt.fighters.SampleFighterTwo;

public class YosokuTatakai {
    public static void main(String[] args) {
        Battle battle = new Battle(
                new SampleFighterOne(),
                new SampleFighterTwo()
        );
        battle.start();
    }
}
