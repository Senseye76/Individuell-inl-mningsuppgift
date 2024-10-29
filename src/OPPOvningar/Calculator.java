package OPPOvningar;

public class Calculator {
    private int num1;
    private int num2;

    public Calculator(int a, int b){
        num1 = a;
        num2 = b;

    }

        public int addition(){
            System.out.println("Resultatet av additon är: " +(num1 + num2));
        return num1 + num2;

        }
        public int subtraktion(){
            System.out.println("Resultatet av subtraktion är: " +(num1 - num2));
            return num1 - num2;
        }
        public int multiplikation() {
            System.out.println("Resultatet av multiplikation är: " +(num1 * num2));
            return num1 * num2;
        }

}
