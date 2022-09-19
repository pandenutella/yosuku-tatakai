package com.pandenutella.yt.custom.characters;

import com.pandenutella.yt.core.Combo;
import com.pandenutella.yt.core.Move;
import com.pandenutella.yt.core.characters.Fighter;
import com.pandenutella.yt.core.moves.Block;
import com.pandenutella.yt.core.moves.Jab;
import com.pandenutella.yt.core.moves.Straight;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class SampleFighterTwo extends Fighter {

    private final Random random = new Random();

    @Override
    public String getName() {
        return "TWFI";
    }

    @Override
    public Combo initiateAttack() {
        return switch (random.nextInt(3)) {
            case 0 -> new Combo(asList(new Jab(), new Straight(), new Straight()));
            case 1 -> new Combo(asList(new Jab(), new Jab(), new Straight()));
            case 2 -> new Combo(asList(new Jab(), new Straight(), new Jab()));
            default -> null;
        };
    }

    @Override
    public Combo formulateCounter(Move firstMove) {
        return switch (firstMove.getName()) {
            case "Jab" -> new Combo(asList(new Block(), new Jab(), new Straight()));
            case "Straight" -> new Combo(asList(new Jab(), new Block(), new Straight()));
            case "Block" -> new Combo(asList(new Straight(), new Jab(), new Block()));
            default -> null;
        };
    }

    @Override
    public void observeEnemyCounter(List<Move> moveList) {
    }
}
