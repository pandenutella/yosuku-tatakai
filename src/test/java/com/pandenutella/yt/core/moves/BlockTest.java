package com.pandenutella.yt.core.moves;

import com.pandenutella.yt.core.Move;
import org.junit.jupiter.api.Test;

import static com.pandenutella.yt.core.Speed.FAST;
import static org.assertj.core.api.Assertions.assertThat;

class BlockTest {

    Move move = new Block();

    @Test
    void when_getName_should_return_Block() {
        assertThat(move.getName()).isEqualTo("Block");
    }

    @Test
    void when_getDamage_should_return_0() {
        assertThat(move.getDamage()).isEqualTo(0);
    }

    @Test
    void when_getShield_should_return_10() {
        assertThat(move.getShield()).isEqualTo(10);
    }

    @Test
    void when_getSpeed_should_return_FAST() {
        assertThat(move.getSpeed()).isEqualTo(FAST);
    }

    @Test
    void when_getPrintedString_should_return_the_correct_printed_string() {
        String printedString = move.getPrintedString();

        assertThat(printedString).isEqualTo("   (  > <)Oo");
    }
}