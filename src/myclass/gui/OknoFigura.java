package myclass.gui;

import myclass.data.Figura;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OknoFigura extends Frame {
    Label labelnazwa;
    TextField textFieldNazwa;
    Button buttonZapisz;
    OknoStart parent;

    public OknoFigura(String title, OknoStart parent) throws HeadlessException {
        super(title);
        this.parent = parent;
        setSize(300,200);
        labelnazwa = new Label("Nazwa");
        textFieldNazwa = new TextField("podaj nazwe figury");
        buttonZapisz = new Button("ZAPISZ");
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        gb.gridx = 0;
        gb.gridy = 0;
        gb.fill = GridBagConstraints.HORIZONTAL;
        add(labelnazwa,gb);
        gb.gridx = 1;
        gb.gridy = 0;
        add(textFieldNazwa,gb);
        gb.gridx = 0;
        gb.gridy = 5;
        gb.gridwidth = 2;
        add(buttonZapisz,gb);

        buttonZapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.dodajFigure(true);
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                parent.dodajFigure(false);
            }
        });


        setVisible(true);
    }

    public Figura getFigura() {
        return null;
    }
}
