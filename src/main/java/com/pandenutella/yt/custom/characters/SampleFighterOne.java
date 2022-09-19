package com.pandenutella.yt.custom.characters;

import com.pandenutella.yt.core.Combo;
import com.pandenutella.yt.core.characters.Fighter;
import com.pandenutella.yt.core.moves.Block;
import com.pandenutella.yt.core.moves.Jab;
import com.pandenutella.yt.core.moves.Straight;

import java.util.Random;

import static java.util.Arrays.asList;

public class SampleFighterOne extends Fighter {

    private final Random random = new Random();

    @Override
    public String getName() {
        return "ONFI";
    }

    @Override
    public Combo initiateAttack() {
        int comboIndicator = random.nextInt(6);

        return getAttackComboByIndicator(comboIndicator);
    }

    @Override
    public Combo formulateCounter() {
        int comboIndicator = random.nextInt(6);

        return getCounterComboByIndicator(comboIndicator);
    }

    private Combo getAttackComboByIndicator(int indicator) {
        return switch (indicator) {
            case 0 -> new Combo(asList(new Jab(), new Jab(), new Straight()));
            case 1 -> new Combo(asList(new Jab(), new Straight(), new Jab()));
            case 2 -> new Combo(asList(new Straight(), new Jab(), new Jab()));
            case 3 -> new Combo(asList(new Straight(), new Straight(), new Jab()));
            case 4 -> new Combo(asList(new Straight(), new Jab(), new Straight()));
            case 5 -> new Combo(asList(new Jab(), new Straight(), new Straight()));
            default -> null;
        };
    }

    private Combo getCounterComboByIndicator(int indicator) {
        return switch (indicator) {
            case 0 -> new Combo(asList(new Block(), new Jab(), new Jab()));
            case 1 -> new Combo(asList(new Jab(), new Block(), new Jab()));
            case 2 -> new Combo(asList(new Jab(), new Jab(), new Block()));
            case 3 -> new Combo(asList(new Jab(), new Block(), new Block()));
            case 4 -> new Combo(asList(new Block(), new Jab(), new Block()));
            case 5 -> new Combo(asList(new Block(), new Block(), new Jab()));
            default -> null;
        };
    }
}
