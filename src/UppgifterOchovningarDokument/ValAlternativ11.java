package UppgifterOchovningarDokument;

public class ValAlternativ11 {
    //Skapa ett program där två tal läses in och det första talet skrivs ut om det är störst.

    public static void main(String[] args) {

        int x = 15;
        int y = 7;

        boolean xLargest = x > y;
        System.out.println(xLargest);

        if (true) System.out.println("Första talet är störst: "+ x);

        if (x > y) System.out.println("Första talet är störst: "+ x);
        else  System.out.println("Andra talet är störst: "+ y);
    }
}
