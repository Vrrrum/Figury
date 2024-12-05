package myclass;

import myclass.data.Baza;
import myclass.gui.OknoStart;

public class Aplikacja {
    public static void main(String[] args) {
        Baza baza = new Baza();
        System.out.println("STaRt");
        OknoStart oknoStart = new OknoStart("Baza figur",baza);
    }
}
