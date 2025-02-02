package Inlamingsuppgifter;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeLogi {
    private static final Map<Character, String> tomorse = new HashMap<>();
    private static final Map<String, Character> totext = new HashMap<>();

    static {
        String[][] morseArray = {
                {"A", ".-"}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.."}, {"E", "."},
                {"F", "..-."}, {"G", "--."}, {"H", "...."}, {"I", ".."}, {"J", ".---"},
                {"K", "-.-"}, {"L", ".-.."}, {"M", "--"}, {"N", "-."}, {"O", "---"},
                {"P", ".--."}, {"Q", "--.-"}, {"R", ".-."}, {"S", "..."}, {"T", "-"},
                {"U", "..-"}, {"V", "...-"}, {"W", ".--"}, {"X", "-..-"}, {"Y", "-.--"},
                {"Z", "--.."}
        };

        for (String[] pair : morseArray) {
            tomorse.put(pair[0].charAt(0), pair[1]);
            totext.put(pair[1], pair[0].charAt(0));
        }
    }

    public static String textToMorse(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Texten kan inte vara tom!");
        }

        text = text.toUpperCase();
        StringBuilder morse = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (tomorse.containsKey(c)) {
                morse.append(tomorse.get(c)).append(" ");
            } else {
                throw new IllegalArgumentException("Ogiltigt tecken i texten: " + c);
            }
        }
        return morse.toString().trim();
    }

    public static String morseToText(String morse) {
        if (morse == null || morse.isEmpty()) {
            throw new IllegalArgumentException("Morsekoden kan inte vara tom!");
        }

        StringBuilder text = new StringBuilder();
        String[] words = morse.split(" ");

        for (String morseLetter : words) {
            if (totext.containsKey(morseLetter)) {
                text.append(totext.get(morseLetter));
            } else {
                throw new IllegalArgumentException("Ogiltig morsekod: " + morseLetter);
            }
        }
        return text.toString();
    }
}
