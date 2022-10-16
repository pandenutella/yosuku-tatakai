package com.pandenutella.yt.core.utilities;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilityTest {

    StringUtility stringUtility = new StringUtility();

    @Test
    void when_flip_given_abc_should_return_cba() {
        String flippedString = stringUtility.flip("abc");

        assertThat(flippedString).isEqualTo("cba");
    }

    @Test
    void when_flip_given_left_parenthesis_should_return_right_parenthesis() {
        String flippedString = stringUtility.flip("(");

        assertThat(flippedString).isEqualTo(")");
    }

    @Test
    void when_flip_given_right_parenthesis_should_return_left_parenthesis() {
        String flippedString = stringUtility.flip(")");

        assertThat(flippedString).isEqualTo("(");
    }

    @Test
    void when_flip_given_less_than_should_return_greater_than() {
        String flippedString = stringUtility.flip("<");

        assertThat(flippedString).isEqualTo(">");
    }

    @Test
    void when_flip_given_greater_than_should_return_less_than() {
        String flippedString = stringUtility.flip(">");

        assertThat(flippedString).isEqualTo("<");
    }
}