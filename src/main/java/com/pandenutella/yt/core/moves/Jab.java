package com.pandenutella.yt.core.moves;

import com.pandenutella.yt.core.Move;
import com.pandenutella.yt.core.Speed;

import static com.pandenutella.yt.core.Speed.FAST;

public class Jab implements Move {
    @Override
    public String getName() {
        return "Jab";
    }

    @Override
    public double getDamage() {
        return 10;
    }

    @Override
    public double getShield() {
        return 0;
    }

    @Override
    public Speed getSpeed() {
        return FAST;
    }
}
