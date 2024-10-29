package UppgifterOchovningarDokument;

import java.util.Scanner;

public class Uppgift44 {
   // 44.Skapa ett program som låter användaren bestämma hur många tal han vill summera. Läs in
   // detta antal tal och summera dem Skriv ut summan.


    public static void main(String[] args) {
        Scanner scannerInput;
        scannerInput = new Scanner(System.in);
        System.out.println("Hur många tal vill du skriva in ");
        int atalTal = scannerInput.nextInt();
        System.out.println(atalTal);

    }

}
