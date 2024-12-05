package myclass.data;

public class Kwadrat extends Figura{
    Double bok;

    public Kwadrat(String nazwa, Double bok) {
        super(nazwa);
        this.bok = bok;
        this.typ = "Kwadrat";
    }

    @Override
    public Double getPole() {
        return bok*bok;
    }
}
