package com.pandenutella.yt.core.printers;

import com.pandenutella.yt.core.Combo;
import com.pandenutella.yt.core.GameCharacter;
import com.pandenutella.yt.core.Printer;
import com.pandenutella.yt.core.moves.Block;
import com.pandenutella.yt.core.moves.Jab;
import com.pandenutella.yt.core.moves.Straight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.pandenutella.yt.core.ConsoleColorUtility.colorBy;
import static com.pandenutella.yt.core.ConsoleColors.BLUE_BOLD;
import static com.pandenutella.yt.core.ConsoleColors.GREEN;
import static com.pandenutella.yt.core.ConsoleColors.GREEN_BACKGROUND;
import static com.pandenutella.yt.core.ConsoleColors.RED;
import static com.pandenutella.yt.core.ConsoleColors.RED_BACKGROUND;
import static com.pandenutella.yt.core.ConsoleColors.YELLOW;
import static com.pandenutella.yt.core.ConsoleColors.YELLOW_BACKGROUND;
import static com.pandenutella.yt.core.ConsoleColors.YELLOW_BOLD;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ActualPrinterTest {

    Printer printer = new ActualPrinter();

    ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    PrintStream originalOutput = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOutput);
    }

    @Test
    void when_printRound_given_message_should_print_message_to_console() {
        printer.printRound(2);

        assertThat("%s 2\r\n".formatted(colorBy("ROUND", BLUE_BOLD))).isEqualTo(outputContent.toString());
    }

    @Test
    void when_printLine_given_message_should_print_message_to_console() {
        printer.printLine("A message");

        assertThat("A message\r\n").isEqualTo(outputContent.toString());
    }

    @Test
    void when_printCharacterStatuses_given_character1_with_hp_0_and_character2_with_hp_100_should_print_0_and_10_barred_health_bars() {
        GameCharacter character1 = mock(GameCharacter.class);
        GameCharacter character2 = mock(GameCharacter.class);

        when(character1.getHP()).thenReturn(0.0);
        when(character1.getMaxHP()).thenReturn(100.0);

        when(character2.getHP()).thenReturn(100.0);
        when(character2.getMaxHP()).thenReturn(100.0);

        printer.printCharacterStatuses(character1, character2);

        assertThat("%s          %s%s%s%s%s%s%s%s%s%s%s%s%s\r\n"
                .formatted(
                        colorBy("[", RED),
                        colorBy("]", RED),
                        colorBy("[", GREEN),
                        colorBy(" ", GREEN_BACKGROUND),
                        colorBy(" ", GREEN_BACKGROUND),
                        colorBy(" ", GREEN_BACKGROUND),
                        colorBy(" ", GREEN_BACKGROUND),
                        colorBy(" ", GREEN_BACKGROUND),
                        colorBy(" ", GREEN_BACKGROUND),
                        colorBy(" ", GREEN_BACKGROUND),
                        colorBy(" ", GREEN_BACKGROUND),
                        colorBy(" ", GREEN_BACKGROUND),
                        colorBy(" ", GREEN_BACKGROUND),
                        colorBy("]", GREEN)
                )
        ).isEqualTo(outputContent.toString());
    }

    @Test
    void when_printCharacterStatuses_given_character1_with_hp_59_and_character2_with_hp_31_should_print_6_and_4_barred_health_bars() {
        GameCharacter character1 = mock(GameCharacter.class);
        GameCharacter character2 = mock(GameCharacter.class);

        when(character1.getHP()).thenReturn(59.0);
        when(character1.getMaxHP()).thenReturn(100.0);

        when(character2.getHP()).thenReturn(31.0);
        when(character2.getMaxHP()).thenReturn(100.0);

        printer.printCharacterStatuses(character1, character2);

        assertThat("%s%s%s%s%s%s%s    %s%s      %s%s%s%s%s\r\n"
                .formatted(
                        colorBy("[", YELLOW),
                        colorBy(" ", YELLOW_BACKGROUND),
                        colorBy(" ", YELLOW_BACKGROUND),
                        colorBy(" ", YELLOW_BACKGROUND),
                        colorBy(" ", YELLOW_BACKGROUND),
                        colorBy(" ", YELLOW_BACKGROUND),
                        colorBy(" ", YELLOW_BACKGROUND),
                        colorBy("]", YELLOW),
                        colorBy("[", RED),
                        colorBy(" ", RED_BACKGROUND),
                        colorBy(" ", RED_BACKGROUND),
                        colorBy(" ", RED_BACKGROUND),
                        colorBy(" ", RED_BACKGROUND),
                        colorBy("]", RED
                        )
                )
        ).isEqualTo(outputContent.toString());
    }

    @Test
    void when_printCharacterCombo_given_character_with_name_CHAR_and_combo_with_moveList_should_print_character_name_and_moveList() {
        GameCharacter character = mock(GameCharacter.class);
        Combo combo = mock(Combo.class);

        when(character.getName()).thenReturn("CHAR");
        when(combo.getMoveList()).thenReturn(asList(new Jab(), new Straight(), new Block()));

        printer.printCharacterCombo(character, combo);

        assertThat("%s: Jab > Straight > Block\r\n".formatted(colorBy("CHAR", YELLOW_BOLD)))
                .isEqualTo(outputContent.toString());
    }
}