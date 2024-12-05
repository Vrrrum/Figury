package myclass.gui;

import myclass.data.Figura;
import myclass.data.Kolo;
import myclass.data.Kwadrat;

import java.awt.*;

public class OknoKolo extends OknoFigura{
    Label lbl_srednica;
    TextField tf_srednica;
    public OknoKolo(String title, OknoStart parent) throws HeadlessException {
        super(title, parent);
        lbl_srednica = new Label("średnica:");
        tf_srednica = new TextField("wpisz dlugosc średnicy");
        GridBagConstraints gb = new GridBagConstraints();
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.gridx = 0;
        gb.gridy = 1;
        add(lbl_srednica,gb);
        gb.gridx = 1;
        gb.gridy = 1;
        add(tf_srednica,gb);
    }

    @Override
    public Figura getFigura() {
        try {
            return new Kolo(textFieldNazwa.getText(), Double.parseDouble(tf_srednica.getText()));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
