package UppgifterOchovningarDokument;

public class Uppgift48 {
//48.Skapa ett program som skriver ut n! (fakulteten). n ska läsas in.
    //Ex: 3! = 1 * 2 * 3 5! = 1 * 2 * 3 * 4 * 5

    public static void main(String[] args) {
        int n;
        n = 3;

        // 3! = 1*2*3

        int produkt = 1;
        for(int i = 1; i <= 3; i++){
            produkt = produkt * i;
            if (i != n ) System.out.print(i + " * ");
            else System.out.print(i);

        }
        System.out.println(" = " +produkt);
    }
}
