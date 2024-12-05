package myclass.gui;

import myclass.data.Figura;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OknoPrzelicz extends Frame {
    Label lbl_pole;
    Label lbl_poleValue;
    OknoStart parent;

    public OknoPrzelicz(String title, Double pole, OknoStart parent) throws HeadlessException {
        super(title);
        this.parent = parent;
        setSize(300,200);
        lbl_pole = new Label("Pole wszystkich figur");
        lbl_poleValue = new Label(String.valueOf(pole));
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        gb.gridx = 0;
        gb.gridy = 0;
        gb.fill = GridBagConstraints.HORIZONTAL;
        add(lbl_pole,gb);
        gb.gridx = 1;
        gb.gridy = 0;
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
