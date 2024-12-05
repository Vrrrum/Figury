package myclass.data;

public class Prostokat extends Figura {
    Double bok1;
    Double bok2;

    public Prostokat(String nazwa, Double bok1, Double bok2) {
        super(nazwa);
        this.bok1 = bok1;
        this.bok2 = bok2;
        this.typ = "Prostokat";
    }

    @Override
    public Double getPole() {
        return bok1*bok2;
    }
}
