package W3School;

public class RandomMedStaffan {
    public static void main(String[] args) {
        int min = 1000;
        int max = 9999;
        int range = max - min + 1;


        for(int i=0;i<10;i++) {
            int rang = (int) (Math.random() * range) + min;
            System.out.println(rang);
        }
    }
}
