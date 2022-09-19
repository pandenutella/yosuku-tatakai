package com.pandenutella.yt.core.characters;

import com.pandenutella.yt.core.Combo;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FighterTest {

    @Test
    void when_receiveDamage_given_10_damage_and_fighter_has_100_hp_should_change_hp_to_90() {
        Fighter fighter = buildFighter();
        assertThat(fighter.getHP()).isEqualTo(100);

        fighter.receiveDamage(10);

        assertThat(fighter.getHP()).isEqualTo(90);
    }

    @Test
    void when_receiveDamage_given_100_damage_and_fighter_has_100_hp_should_change_hp_to_0() {
        Fighter fighter = buildFighter();
        assertThat(fighter.getHP()).isEqualTo(100);

        fighter.receiveDamage(100);

        assertThat(fighter.getHP()).isEqualTo(0);
    }

    @Test
    void when_receiveDamage_given_101_damage_and_fighter_has_100_hp_should_change_hp_to_0() {
        Fighter fighter = buildFighter();
        assertThat(fighter.getHP()).isEqualTo(100);

        fighter.receiveDamage(101);

        assertThat(fighter.getHP()).isEqualTo(0);
    }

    @Test
    void when_getMaxHP_should_return_100() {
        Fighter fighter = buildFighter();

        assertThat(fighter.getMaxHP()).isEqualTo(100);
    }

    @Test
    void when_getHP_given_hp_is_unmodified_yet_should_be_equal_to_maxHP() {
        Fighter fighter = buildFighter();

        assertThat(fighter.getHP()).isEqualTo(fighter.getMaxHP());
    }

    Fighter buildFighter() {
        return new Fighter() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public Combo initiateAttack() {
                return null;
            }

            @Override
            public Combo formulateCounter() {
                return null;
            }
        };
    }
}