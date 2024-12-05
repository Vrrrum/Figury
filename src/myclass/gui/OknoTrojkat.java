package myclass.gui;

import myclass.data.Figura;
import myclass.data.Kwadrat;
import myclass.data.Trojkat;

import java.awt.*;

public class OknoTrojkat extends OknoFigura{
    Label lbl_podstawa;
    Label lbl_wysokosc;
    TextField tf_podstawa;
    TextField tf_wysokosc;
    public OknoTrojkat(String title, OknoStart parent) throws HeadlessException {
        super(title, parent);
        lbl_podstawa = new Label("Podstawa:");
        tf_podstawa = new TextField("wpisz dlugosc podstawy");
        GridBagConstraints gb = new GridBagConstraints();
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.gridx = 0;
        gb.gridy = 1;
        add(lbl_podstawa,gb);
        gb.gridx = 1;
        gb.gridy = 1;
        add(tf_podstawa,gb);

        lbl_wysokosc = new Label("Wysokość:");
        tf_wysokosc = new TextField("wpisz dlugosc wysokości");
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.gridx = 0;
        gb.gridy = 2;
        add(lbl_wysokosc,gb);
        gb.gridx = 1;
        gb.gridy = 2;
        add(tf_wysokosc,gb);
    }

    @Override
    public Figura getFigura() {
        try {
            return new Trojkat(textFieldNazwa.getText(), Double.parseDouble(tf_podstawa.getText()), Double.parseDouble(tf_wysokosc.getText()));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
