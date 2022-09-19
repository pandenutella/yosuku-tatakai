package com.pandenutella.yt.core.moves;

import com.pandenutella.yt.core.Move;
import org.junit.jupiter.api.Test;

import static com.pandenutella.yt.core.Speed.SLOW;
import static org.assertj.core.api.Assertions.assertThat;

class StraightTest {

    Move move = new Straight();

    @Test
    void when_getName_should_return_Straight() {
        assertThat(move.getName()).isEqualTo("Straight");
    }

    @Test
    void when_getDamage_should_return_20() {
        assertThat(move.getDamage()).isEqualTo(20);
    }

    @Test
    void when_getShield_should_return_0() {
        assertThat(move.getShield()).isEqualTo(0);
    }

    @Test
    void when_getSpeed_should_return_SLOW() {
        assertThat(move.getSpeed()).isEqualTo(SLOW);
    }
}