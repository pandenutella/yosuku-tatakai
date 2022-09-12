package com.pandenutella.yt.core;

import com.pandenutella.yt.core.config.Printer;
import com.pandenutella.yt.core.enums.Speed;
import lombok.Getter;
import lombok.Setter;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

@Getter(PROTECTED)
public abstract class Move {

    @Setter(PACKAGE)
    private Printer printer;

    protected abstract Speed getSpeed();

    protected abstract void perform(Fighter user, Fighter target);
}
