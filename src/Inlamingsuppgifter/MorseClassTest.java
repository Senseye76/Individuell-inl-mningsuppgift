package Inlamingsuppgifter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MorseClassTest {

    @Test
    public void testTextToMorse() {
        assertEquals(".... . .-.. .-.. ---", MorseClassLogi.textToMorse("HELLO"));
    }

    @Test
    public void testMorseToText() {
        assertEquals("HELLO", MorseClassLogi.morseToText(".... . .-.. .-.. ---"));
    }
    // Testar att små bokstäver hanteras korrekt och omvandlas till morsekod.
    @Test
    public void testLowercaseTextToMorse() {
        assertEquals(".-- --- .-. .-.. -..", MorseClassLogi.textToMorse("world"));
    }
    // Testar om en blandning av text och morsekod kastar ett undantag.
    @Test
    public void testMixedInputTextToMorse() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MorseClassLogi.textToMorse("HELLO ... --- ...");
        });
        assertTrue(exception.getMessage().startsWith("Ogiltigt tecken i texten:"));
    }

    @Test
    public void testInvalidMorseCode() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MorseClassLogi.morseToText(".... --- .-- --..--");
        });
        assertTrue(exception.getMessage().startsWith("Ogiltig morsekod:"));
    }
}
