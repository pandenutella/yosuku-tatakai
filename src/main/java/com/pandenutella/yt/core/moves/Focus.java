package com.pandenutella.yt.core.moves;

import com.pandenutella.yt.core.Fighter;
import com.pandenutella.yt.core.Move;
import com.pandenutella.yt.core.enums.Speed;

import static com.pandenutella.yt.core.enums.Speed.NORMAL;
import static com.pandenutella.yt.core.utilities.BattleUtility.displayMoveUsed;

public class Focus implements Move {
    @Override
    public Speed getSpeed() {
        return NORMAL;
    }

    @Override
    public void perform(Fighter user, Fighter target) {
        double damageMultiplier = 1.5;
        user.setDamageMultiplier(damageMultiplier);

        displayMoveUsed(user.getName(), "Focus", null,
                "granting %s damage multiplier after the next time you deal damage this round".formatted(damageMultiplier));
    }
}
