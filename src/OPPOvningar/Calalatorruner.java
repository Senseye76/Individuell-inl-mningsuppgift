package OPPOvningar;
//Calculator calculator = new Calculator(7,3);
////        System.out.println(calculator.addition());

import java.util.Scanner;

public class Calalatorruner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv in första talet");
        int num1 = scanner.nextInt();
        System.out.println("Skriv in ditt andra tal");
        int num2 = scanner.nextInt();

        Calculator calc = new Calculator(num1, num2);

        System.out.println(calc.addition());
        System.out.println(calc.subtraktion());
        System.out.println(calc.multiplikation());
    }
}
