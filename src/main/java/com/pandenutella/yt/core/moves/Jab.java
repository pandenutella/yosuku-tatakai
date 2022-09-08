package com.pandenutella.yt.core.moves;

import com.pandenutella.yt.core.Fighter;
import com.pandenutella.yt.core.Move;
import com.pandenutella.yt.core.enums.Speed;

import static com.pandenutella.yt.core.enums.Color.BOLD_RED;
import static com.pandenutella.yt.core.enums.Speed.FAST;
import static com.pandenutella.yt.core.utilities.BattleUtility.displayMoveUsed;
import static com.pandenutella.yt.core.utilities.ColorUtility.colorTextWith;
import static java.lang.String.valueOf;

public class Jab implements Move {
    @Override
    public Speed getSpeed() {
        return FAST;
    }

    @Override
    public void perform(Fighter user, Fighter target) {
        double damage = user.dealDamage(10);
        double dealtDamage = target.receiveDamage(damage);

        displayMoveUsed(user.getName(), "Jab", target.getName(),
                "dealing %s damage".formatted(colorTextWith(valueOf(dealtDamage), BOLD_RED)));
    }
}
