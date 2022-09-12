package com.pandenutella.yt;

import com.pandenutella.yt.core.Battle;
import com.pandenutella.yt.core.MoveFactory;
import com.pandenutella.yt.core.Utility;
import com.pandenutella.yt.core.config.ActualUtility;
import com.pandenutella.yt.fighters.SampleFighterOne;
import com.pandenutella.yt.fighters.SampleFighterTwo;

public class YosokuTatakai {
    public static void main(String[] args) {
        Utility utility = new ActualUtility();
        MoveFactory moveFactory = new MoveFactory(utility.getPrinter());

        Battle battle = new Battle(
                new SampleFighterOne(),
                new SampleFighterTwo(),
                moveFactory,
                utility
        );
        battle.start();
    }
}
