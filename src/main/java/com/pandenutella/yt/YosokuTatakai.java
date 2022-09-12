package com.pandenutella.yt;

import com.pandenutella.yt.core.Battle;
import com.pandenutella.yt.core.Utility;
import com.pandenutella.yt.core.config.ActualUtility;
import com.pandenutella.yt.core.utilities.ManaCostConverter;
import com.pandenutella.yt.mages.SampleMageOne;
import com.pandenutella.yt.mages.SampleMageTwo;

public class YosokuTatakai {
    public static void main(String[] args) {
        Utility utility = new ActualUtility();
        int spellsPerRound = 3;
        ManaCostConverter manaCostConverter = new ManaCostConverter();

        Battle battle = new Battle(
                new SampleMageOne(),
                new SampleMageTwo(),
                utility,
                spellsPerRound,
                manaCostConverter
        );
        battle.start();
    }
}
