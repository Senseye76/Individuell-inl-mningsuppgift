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

    @Test
    public void testLowercaseTextToMorse() {
        assertEquals(".-- --- .-. .-.. -..", MorseCodeLogi.textToMorse("world"));
    }

    @Test
    public void testInvalidCharacter() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MorseCodeLogi.textToMorse("Hello123");
        });
        assertEquals("Ogiltigt tecken i texten: 1", exception.getMessage());
    }

    @Test
    public void testEmptyInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MorseCodeLogi.textToMorse("");
        });
        assertEquals("Texten kan inte vara tom!", exception.getMessage());
    }
}
