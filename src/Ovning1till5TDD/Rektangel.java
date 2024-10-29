package Ovning1till5TDD;

public class Rektangel {
    private double bredd;
    private double hojd;


    public Rektangel(double inputBredd, double inputHojd) {
        bredd = inputBredd;
        hojd = inputHojd;
    }

    public double calculatebredd() {
    return bredd;
    }
    public double calculatehojd() {
        return hojd;
    }
    public double calculateArea() {
        return bredd * hojd;
    }

}

