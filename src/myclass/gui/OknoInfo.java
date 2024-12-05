package myclass.gui;

import myclass.data.Figura;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OknoInfo extends Frame {
    Label lbl_nazwa;
    Label lbl_typ;
    Label lbl_pole;

    Label lbl_nazwaValue;
    Label lbl_typValue;
    Label lbl_poleValue;
    Figura figura;
    OknoStart parent;

    public OknoInfo(String title, Figura figura, OknoStart parent) throws HeadlessException {
        super(title);
        this.parent = parent;
        this.figura = figura;
        setSize(300,200);
        lbl_nazwa = new Label("Nazwa");
        lbl_typ = new Label("Typ");
        lbl_pole = new Label("Pole");

        lbl_nazwaValue = new Label(figura.getNazwa());
        lbl_typValue = new Label(figura.getTyp());
        lbl_poleValue = new Label(String.valueOf(figura.getPole()));

        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        gb.gridx = 0;
        gb.gridy = 0;
        gb.fill = GridBagConstraints.HORIZONTAL;
        add(lbl_nazwa,gb);
        gb.gridx = 1;
        gb.gridy = 0;
        add(lbl_nazwaValue,gb);
        gb.gridx = 0;
        gb.gridy = 2;
        add(lbl_typ,gb);
        gb.gridx = 1;
        gb.gridy = 2;
        add(lbl_typValue,gb);
        gb.gridx = 0;
        gb.gridy = 3;
        add(lbl_pole,gb);
        gb.gridx = 1;
        gb.gridy = 3;
        add(lbl_poleValue,gb);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                parent.setEnabled(true);
                dispose();
            }
        });
        setVisible(true);
    }
}
