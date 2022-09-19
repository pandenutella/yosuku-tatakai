package com.pandenutella.yt.core.printers;

import com.pandenutella.yt.core.GameCharacter;
import com.pandenutella.yt.core.Printer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

        assertThat("[          ][<<<<<<<<<<]\r\n").isEqualTo(outputContent.toString());
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

        assertThat("[>>>>>>    ][      <<<<]\r\n").isEqualTo(outputContent.toString());
    }
}