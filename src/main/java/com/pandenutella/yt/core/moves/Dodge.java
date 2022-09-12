package com.pandenutella.yt.core.moves;

import com.pandenutella.yt.core.Fighter;
import com.pandenutella.yt.core.Move;
import com.pandenutella.yt.core.enums.Speed;

import static com.pandenutella.yt.core.enums.Speed.FAST;

public class Dodge extends Move {

    @Override
    protected Speed getSpeed() {
        return FAST;
    }

    @Override
    public void perform(Fighter user, Fighter target) {
        user.setNimble(true);

        getPrinter().printMoveUsed(user.getName(), "Dodge", null, "granting evasion until the next move");
    }
}
