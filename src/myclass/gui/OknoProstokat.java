package myclass.gui;

import myclass.data.Figura;
import myclass.data.Kwadrat;

import java.awt.*;

public class OknoProstokat extends OknoFigura {
    Label lbl_bok1;
    Label lbl_bok2;
    TextField tf_bok1;
    TextField tf_bok2;
    public OknoProstokat(String title, OknoStart parent) throws HeadlessException {
        super(title, parent);
        lbl_bok1 = new Label("Bok a:");
        tf_bok1 = new TextField("wpisz dlugosc boku");
        GridBagConstraints gb = new GridBagConstraints();
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.gridx = 0;
        gb.gridy = 1;
        add(lbl_bok1,gb);
        gb.gridx = 1;
        gb.gridy = 1;
        add(tf_bok1,gb);

        lbl_bok2 = new Label("Bok a:");
        tf_bok2 = new TextField("wpisz dlugosc boku");
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.gridx = 0;
        gb.gridy = 2;
        add(lbl_bok2,gb);
        gb.gridx = 1;
        gb.gridy = 2;
        add(tf_bok2,gb);
    }

    @Override
    public Figura getFigura() {
        return new Kwadrat(textFieldNazwa.getText(),Double.parseDouble(tf_bok1.getText()));
    }
}
