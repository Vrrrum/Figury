package myclass.data;

import java.io.Serial;

public class Figura implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    String nazwa;
    String typ;

    public Figura(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }
    public Double getPole(){
        return 0.0;
    }
    public String getTyp() {
        return typ;
    }
}
