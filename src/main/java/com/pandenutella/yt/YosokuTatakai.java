package com.pandenutella.yt;

import com.pandenutella.yt.core.Battle;
import com.pandenutella.yt.core.GameCharacter;
import com.pandenutella.yt.core.config.ActualConfig;
import com.pandenutella.yt.core.exceptions.AllowedRepeatedMovesExceededException;
import com.pandenutella.yt.core.exceptions.InvalidNumberOfMovesInComboException;
import com.pandenutella.yt.custom.characters.SampleFighterOne;
import com.pandenutella.yt.custom.characters.SampleFighterTwo;

public class YosokuTatakai {
    public static void main(String[] args) throws InvalidNumberOfMovesInComboException, AllowedRepeatedMovesExceededException {
        GameCharacter character1 = new SampleFighterOne();
        GameCharacter character2 = new SampleFighterTwo();

        Battle battle = new Battle(character1, character2, new ActualConfig());
        battle.fight();
    }
}
