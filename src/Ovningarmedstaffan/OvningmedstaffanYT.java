package Ovningarmedstaffan;
//Jämför två tal. Om det första är större än det andra skriv ut ”Första talet är störst”, samt ”Andra talet är störst” om det är tvärtom
//
//Jämför två tal. Om det första är jämt delbart med det andra skriv ut ”Jämt delbart”, annars skriv ut ”Inte jämt delbart”

public class OvningmedstaffanYT {

    public static void main(String[] args) {
        int num1 = 25;
        int num2 = 5;

        if (num1 > num2) {
        System.out.println("Första talet är störst");
        } else if (num1 < num2) {
            System.out.println("Andra talet är störst");
        }


        if (num1%num2==0) {
            System.out.println("Jämt delbart");{
            }
        } else {
            System.out.println("Inte jämt delbart");


        }
    }

}