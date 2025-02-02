package Inlamingsuppgifter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MorseTest {
    MorseLogi morseLogi = new MorseLogi();

    @Test
    void testTextTillMorse() {
        assertEquals(".... . .-.. .-.. ---", morseLogi.textToMorse("HELLO"));
    }

    @Test
    void testMorseTillText() {
        assertEquals("HELLO", morseLogi.morseToText(".... . .-.. .-.. ---"));
    }

    @Test
    void testOgiltigtTeckenTextTillMorse() {
        assertEquals("Fel: Ogiltigt tecken: @", morseLogi.textToMorse("HELLO@"));
    }

    @Test
    void testOgiltigMorseKod() {
        assertEquals("Fel: Ogiltig Morse-kod: ....-", morseLogi.morseToText("....-"));
    }

    @Test
    void testLitenOchStorBokstav() {
        assertEquals(".... . .-.. .-.. ---", morseLogi.textToMorse("hello"));
    }
}
