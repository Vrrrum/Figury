package myclass.data;

public class Trojkat extends Figura {
    Double podstawa;
    Double wysokosc;

    public Trojkat(String nazwa, Double podstawa, Double wysokosc) {
        super(nazwa);
        this.podstawa = podstawa;
        this.wysokosc = wysokosc;
        this.typ = "Trojkat";
    }

    @Override
    public Double getPole() {
        return podstawa*wysokosc*0.5;
    }
}
