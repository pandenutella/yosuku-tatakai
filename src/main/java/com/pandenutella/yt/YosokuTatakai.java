package com.pandenutella.yt;

import com.pandenutella.yt.core.Battle;
import com.pandenutella.yt.core.CharacterMoveExecutor;
import com.pandenutella.yt.core.Clock;
import com.pandenutella.yt.core.GameCharacter;
import com.pandenutella.yt.core.Printer;
import com.pandenutella.yt.core.clocks.ActualClock;
import com.pandenutella.yt.core.exceptions.AllowedRepeatedMovesExceededException;
import com.pandenutella.yt.core.exceptions.InvalidNumberOfMovesInComboException;
import com.pandenutella.yt.core.printers.ActualPrinter;
import com.pandenutella.yt.custom.characters.SampleFighterOne;
import com.pandenutella.yt.custom.characters.SampleFighterTwo;

public class YosokuTatakai {
    public static void main(String[] args) throws InvalidNumberOfMovesInComboException, AllowedRepeatedMovesExceededException {
        GameCharacter character1 = new SampleFighterOne();
        GameCharacter character2 = new SampleFighterTwo();

        CharacterMoveExecutor executor1 = new CharacterMoveExecutor(character2);
        CharacterMoveExecutor executor2 = new CharacterMoveExecutor(character1);

        Printer printer = new ActualPrinter();
        Clock clock = new ActualClock();

        Battle battle = new Battle(character1, character2, executor1, executor2, printer, clock);
        battle.fight();
    }
}
