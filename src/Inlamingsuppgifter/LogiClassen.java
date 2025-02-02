package Inlamingsuppgifter;

import java.util.HashMap;

class MorseLogi {
    private HashMap<String, String> morseMap = new HashMap<>();
    private HashMap<String, String> reverseMorseMap = new HashMap<>();

    public MorseLogi() {
        String[] letters = {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"
        };

        String[] morse = {
                ".", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        for (int i = 0; i < letters.length; i++) {
            morseMap.put(letters[i], morse[i]);
            reverseMorseMap.put(morse[i], letters[i]);
        }
    }

    public String textToMorse(String text) {
        StringBuilder morseCode = new StringBuilder();
        text = text.toUpperCase();

        try {
            for (char c : text.toCharArray()) {
                String letter = String.valueOf(c); // Gör om char till String
                if (morseMap.containsKey(letter)) {
                    morseCode.append(morseMap.get(letter)).append(" ");
                } else {
                    throw new IllegalArgumentException("Ogiltigt tecken: " + letter);
                }
            }
        } catch (IllegalArgumentException e) {
            return "Fel: " + e.getMessage();
        }
        return morseCode.toString().trim();
    }

    public String morseToText(String morse) {
        StringBuilder text = new StringBuilder();
        String[] morseWords = morse.split(" ");

        try {
            for (String morseChar : morseWords) {
                if (reverseMorseMap.containsKey(morseChar)) {
                    text.append(reverseMorseMap.get(morseChar));
                } else {
                    throw new IllegalArgumentException("Ogiltig Morse-kod: " + morseChar);
                }
            }
        } catch (IllegalArgumentException e) {
            return "Fel: " + e.getMessage();
        }
        return text.toString();
    }
}
