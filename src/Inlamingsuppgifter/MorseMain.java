package Inlamingsuppgifter;

import java.util.Scanner;

public class MorseMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MorseLogi morseLogi = new MorseLogi();

        System.out.println("Hello Hello välkommen till Morse-kod-översättaren!");
        while (true) {
            System.out.println("Snälla välj ett alternativ:");
            System.out.println("1: Gör om text till Morse-kod");
            System.out.println("2: Gör om Morse-kod till text");
            System.out.println("3: Avsluta");

            int val;
            try {
                val = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Fel: Ange ett giltigt nummer mellan (1-3).");
                continue;
            }

            if (val == 1) {
                System.out.println("Skriv in text att konvertera:");
                String text = scanner.nextLine();
                System.out.println("Morse-kod: " + morseLogi.textToMorse(text));
            } else if (val == 2) {
                System.out.println("Skriv in Morse-kod att konvertera (separera bokstäver med mellanslag):");
                String morse = scanner.nextLine();
                System.out.println("Text: " + morseLogi.morseToText(morse));
            } else if (val == 3) {
                System.out.println("Programmet avslutas. HejHejdåå!");
                break;
            } else {
                System.out.println("Ogiltigt val, försök igen!");
            }
        }
        scanner.close();
    }
}
