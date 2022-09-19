package com.pandenutella.yt.core;

import org.junit.jupiter.api.Test;

import static com.pandenutella.yt.core.ConsoleColorUtility.colorBy;
import static com.pandenutella.yt.core.ConsoleColors.RED;
import static org.assertj.core.api.Assertions.assertThat;

class ConsoleColorUtilityTest {

    @Test
    void when_colorBy_given_a_text_and_a_color_should_return_a_colored_text() {
        String coloredText = colorBy("A text", RED);

        assertThat("%sA text%s".formatted(RED.getAnsi(), "\033[0m")).isEqualTo(coloredText);
    }
}