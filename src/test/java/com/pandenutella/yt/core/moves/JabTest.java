package com.pandenutella.yt.core.moves;

import com.pandenutella.yt.core.Move;
import org.junit.jupiter.api.Test;

import static com.pandenutella.yt.core.Speed.FAST;
import static org.assertj.core.api.Assertions.assertThat;

class JabTest {

    Move move = new Jab();

    @Test
    void when_getName_should_return_Jab() {
        assertThat(move.getName()).isEqualTo("Jab");
    }

    @Test
    void when_getDamage_should_return_10() {
        assertThat(move.getDamage()).isEqualTo(10);
    }

    @Test
    void when_getShield_should_return_0() {
        assertThat(move.getShield()).isEqualTo(0);
    }

    @Test
    void when_getSpeed_should_return_FAST() {
        assertThat(move.getSpeed()).isEqualTo(FAST);
    }
}