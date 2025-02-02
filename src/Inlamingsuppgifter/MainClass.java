package Inlamingsuppgifter;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Välj ett alternativ:");
        System.out.println("1. Omvandla text till morsekod");
        System.out.println("2. Omvandla morsekod till text");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Ange text: ");
                String text = scanner.nextLine();
                try {
                    String morse = MorseCodeLogi.textToMorse(text);
                    System.out.println("Morsekod: " + morse);
                } catch (IllegalArgumentException e) {
                    System.out.println("Fel: " + e.getMessage());
                }
                break;
            case 2:
                System.out.print("Ange morsekod (separera bokstäver med mellanslag): ");
                String morse = scanner.nextLine();
                try {
                    String convertedText = MorseCodeLogi.morseToText(morse);
                    System.out.println("Översatt text: " + convertedText);
                } catch (IllegalArgumentException e) {
                    System.out.println("Fel: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Ogiltigt val!");
        }

        scanner.close();
    }
}
