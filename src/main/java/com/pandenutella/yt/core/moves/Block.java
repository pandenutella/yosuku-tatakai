package com.pandenutella.yt.core.moves;

import com.pandenutella.yt.core.Fighter;
import com.pandenutella.yt.core.Move;
import com.pandenutella.yt.core.enums.Speed;

import static com.pandenutella.yt.core.enums.Color.BOLD_GREEN;
import static com.pandenutella.yt.core.enums.Speed.SLOW;
import static com.pandenutella.yt.core.utilities.BattleUtility.displayMoveUsed;
import static com.pandenutella.yt.core.utilities.ColorUtility.colorTextWith;
import static java.lang.String.valueOf;

public class Block implements Move {
    @Override
    public Speed getSpeed() {
        return SLOW;
    }

    @Override
    public void perform(Fighter user, Fighter target) {
        double shield = 20;
        user.setShield(shield);

        displayMoveUsed(user.getName(), "Block", null,
                "granting %s shield until the next round".formatted(colorTextWith(valueOf(shield), BOLD_GREEN)));
    }
}
