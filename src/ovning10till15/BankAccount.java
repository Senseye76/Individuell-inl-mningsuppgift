package ovning10till15;

public class BankAccount {
    private double saldo;


    public BankAccount (double mittSaldo) {
    saldo = mittSaldo;}

    public void visaMittSaldo() {
        System.out.println("Mitt saldo är " +saldo);

    }
    public void sattSaldo(double nyttSaldo) {
        saldo = nyttSaldo;
        System.out.println("Ditt ny saldo är: " +saldo + " kr");
    }
    public void LaggTillPengar(double summa) {
        saldo += summa;
        System.out.println(summa + " kr har lagts till på ditt konto. Mitt nya saldo är: " + saldo + "kr");
    }
}
