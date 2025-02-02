import java.util.Scanner;

public class Matte {
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        double c = Math.sqrt(a*a * b*b);

        System.out.println("C blir = " + c);


        //double a = 6*6;
        //double b = 8*8;
       // double c = a+b;

       // double hypo = Math.sqrt(c);
        //double d = Math.pow(c, 2);

        //System.out.println("Hypotenusan är:" + hypo);
    }
}
