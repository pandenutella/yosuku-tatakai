package com.pandenutella.yt.fighters;

import com.pandenutella.yt.combos.SampleComboOne;
import com.pandenutella.yt.combos.SampleComboThree;
import com.pandenutella.yt.combos.SampleComboTwo;
import com.pandenutella.yt.core.Combo;
import com.pandenutella.yt.core.Fighter;
import com.pandenutella.yt.core.Move;

import java.util.List;
import java.util.Random;

public class SampleFighterTwo extends Fighter {
    private final Random random = new Random();

    @Override
    public String getName() {
        return "TWFI";
    }

    @Override
    protected Combo executeCombo(double life, double enemyLife) {
        return getRandomCombo();
    }

    @Override
    protected Combo executeCounterCombo(double life, double enemyLife, List<Move> enemyMoveList) {
        return getRandomCombo();
    }

    private Combo getRandomCombo() {
        int randomComboNumber = random.nextInt(3 - 1) + 1;

        return switch (randomComboNumber) {
            case 1 -> new SampleComboOne();
            case 2 -> new SampleComboTwo();
            case 3 -> new SampleComboThree();
            default -> throw new IllegalStateException("Unexpected value: %d".formatted(randomComboNumber));
        };
    }
}
