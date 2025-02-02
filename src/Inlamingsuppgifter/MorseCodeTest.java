package Inlamingsuppgifter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MorseCodeTest {

    @Test
    public void testTextToMorse() {
        assertEquals(".... . .-.. .-.. ---", MorseCodeLogi.textToMorse("HELLO"));
    }

    @Test
    public void testMorseToText() {
        assertEquals("HELLO", MorseCodeLogi.morseToText(".... . .-.. .-.. ---"));
    }
    // Testar att små bokstäver hanteras korrekt och omvandlas till morsekod.
    @Test
    public void testLowercaseTextToMorse() {
        assertEquals(".-- --- .-. .-.. -..", MorseCodeLogi.textToMorse("world"));
    }
    // Testar om en blandning av text och morsekod kastar ett undantag.
    @Test
    public void testMixedInputTextToMorse() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MorseCodeLogi.textToMorse("HELLO ... --- ...");
        });
        assertTrue(exception.getMessage().startsWith("Ogiltigt tecken i texten:"));
    }

    @Test
    public void testInvalidMorseCode() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MorseCodeLogi.morseToText(".... --- .-- --..--");
        });
        assertTrue(exception.getMessage().startsWith("Ogiltig morsekod:"));
    }
}
