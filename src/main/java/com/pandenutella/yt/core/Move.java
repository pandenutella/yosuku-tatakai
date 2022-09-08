package com.pandenutella.yt.core;

import com.pandenutella.yt.core.enums.Speed;

public interface Move {

    Speed getSpeed();

    void perform(Fighter user, Fighter target);
}
