package com.pandenutella.yt.core.moves;

import com.pandenutella.yt.core.Move;
import com.pandenutella.yt.core.Speed;

import static com.pandenutella.yt.core.Speed.FAST;

public class Block implements Move {
    @Override
    public String getName() {
        return "Block";
    }

    @Override
    public double getDamage() {
        return 0;
    }

    @Override
    public double getShield() {
        return 10;
    }

    @Override
    public Speed getSpeed() {
        return FAST;
    }

    @Override
    public String getPrintedString() {
        return "   (  > <)Oo";
    }
}
