package com.pandenutella.yt.core.moves;

import com.pandenutella.yt.core.Move;
import com.pandenutella.yt.core.Speed;

import static com.pandenutella.yt.core.Speed.SLOW;

public class Straight implements Move {
    @Override
    public String getName() {
        return "Straight";
    }

    @Override
    public double getDamage() {
        return 20;
    }

    @Override
    public double getShield() {
        return 0;
    }

    @Override
    public Speed getSpeed() {
        return SLOW;
    }
}
