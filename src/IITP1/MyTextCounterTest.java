package IITP1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class MyTextCounterTest {

    //Testar om det är rätt antal rader som räknas
    @Test
    public void testRadRaknare() {
        MyTextCounter stats = new MyTextCounter();
        stats.addLine("Rad ett");
        stats.addLine("Rad två");
        stats.addLine("Rad tre");
        assertEquals(3, stats.getLineCount());
    }
//Testar om tecken räkans rätt
    @Test
    public void testWordRaknare() {
        MyTextCounter stats = new MyTextCounter();
        stats.addLine("Första raden");
        stats.addLine("Andra raden");
        assertEquals(23, stats.getWordCount());

    }
//Testar om en tom rad hanteras rätt
    @Test
    public void testEmptyLine() {
        MyTextCounter stats = new MyTextCounter();
        stats.addLine("");
        assertEquals(1, stats.getLineCount());
        assertEquals(0, stats.getWordCount());

    }
}