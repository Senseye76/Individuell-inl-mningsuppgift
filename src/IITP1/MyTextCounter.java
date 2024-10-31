package IITP1;

public class MyTextCounter {
    private int lineCount = 0;
    private int characterCount = 0;

    public void addLine(String line) {
        lineCount++;
        characterCount += line.length();
    }

    public int getLineCount() {
        return lineCount;

    }

    public int getWordCount() {
        return characterCount;
    }

    public void printMyCounter() {
        System.out.println("Antal rader: " + lineCount);
        System.out.println("Antal tecken: " + characterCount);


    }

}
