package com.pandenutella.yt.core.moves;

import com.pandenutella.yt.core.Fighter;
import com.pandenutella.yt.core.Move;
import com.pandenutella.yt.core.enums.Speed;

import static com.pandenutella.yt.core.enums.Color.BOLD_RED;
import static com.pandenutella.yt.core.enums.Speed.NORMAL;
import static com.pandenutella.yt.core.utilities.ColorUtility.colorTextWith;
import static java.lang.String.valueOf;

public class Straight extends Move {
    @Override
    public Speed getSpeed() {
        return NORMAL;
    }

    @Override
    public void perform(Fighter user, Fighter target) {
        double damage = user.dealDamage(15);
        double dealtDamage = target.receiveDamage(damage);

        getPrinter().printMoveUsed(user.getName(), "Straight", target.getName(),
                "dealing %s damage".formatted(colorTextWith(valueOf(dealtDamage), BOLD_RED)));
    }
}
