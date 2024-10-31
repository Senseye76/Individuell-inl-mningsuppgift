package IITP1;


import java.util.Scanner;

public class TextToUser {
    private MyTextCounter textCounter = new MyTextCounter();


    public void readText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv in din text och avsluta med 'stop' för att avsluta:");

        while (true) {
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("stop")){
                break;
            }
            textCounter.addLine(input);
        }
        textCounter.printMyCounter();
    }
}

