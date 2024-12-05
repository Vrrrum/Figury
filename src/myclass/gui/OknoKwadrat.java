package myclass.gui;

import myclass.data.Figura;
import myclass.data.Kwadrat;

import java.awt.*;

public class OknoKwadrat extends OknoFigura{
    Label labelbok;
    TextField textFieldbok;
    public OknoKwadrat(String title, OknoStart parent) throws HeadlessException {
        super(title, parent);
        labelbok = new Label("Bok:");
        textFieldbok = new TextField("wpisz dlugosc boku");
        GridBagConstraints gb = new GridBagConstraints();
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.gridx = 0;
        gb.gridy = 1;
        add(labelbok,gb);
        gb.gridx = 1;
        gb.gridy = 1;
        add(textFieldbok,gb);
    }

    @Override
    public Figura getFigura() {
        return new Kwadrat(textFieldNazwa.getText(),Double.parseDouble(textFieldbok.getText()));
    }
}
