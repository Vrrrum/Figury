package myclass.data;

public class Kolo extends Figura{
    Double srednica;

    public Kolo(String nazwa, Double srednica) {
        super(nazwa);
        this.srednica = srednica;
        this.typ = "Kolo";
    }

    @Override
    public Double getPole() {
        return Math.pow(srednica, 2)*Math.PI;
    }
}
