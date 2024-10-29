package UppgifterOchovningarDokument;

import java.util.Scanner;

public class Uppgift5 {

    public static void main(String[] args) {
        System.out.println("Ange en pris i sek ");
        Scanner scanner = new Scanner(System.in);
        int sek = scanner.nextInt();

        //Man skulle kunna ändra till en double för att vara mer specifik
        int pund = 10;
        int dollar = 6;
        pund = sek / pund;
        dollar = sek / dollar;

        System.out.println(pund);
        System.out.println(dollar);
        System.out.println("Pris i pund är " + pund + " Pris i dollar är "+ dollar);
    }
}
