package com.pandenutella.yt.core.moves;

import com.pandenutella.yt.core.Fighter;
import com.pandenutella.yt.core.Move;
import com.pandenutella.yt.core.enums.Speed;

import static com.pandenutella.yt.core.enums.Speed.FAST;
import static com.pandenutella.yt.core.utilities.BattleUtility.displayMoveUsed;

public class Dodge implements Move {
    @Override
    public Speed getSpeed() {
        return FAST;
    }

    @Override
    public void perform(Fighter user, Fighter target) {
        user.setNimble(true);

        displayMoveUsed(user.getName(), "Dodge", null, "granting evasion until the next move");
    }
}
