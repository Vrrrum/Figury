package myclass.gui;

import myclass.data.Baza;
import myclass.data.Figura;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

public class OknoStart extends Frame {
    Label labelLista;
    Label labelChoice;
    List listaFigur;
    Choice choiceFigury;
    Button buttonDodaj;
    Button buttonUsun;
    Button buttonInfo;
    MenuBar menuBar;
    Menu menuPlik;
    Menu menubaza;
    MenuItem menuItemNowa;
    MenuItem menuItemZapisz;
    MenuItem menuItemWczytaj;
    MenuItem menuItemCzysc;
    MenuItem menuItemPrzelicz;
    OknoFigura oknoFigura;
    OknoInfo oknoInfo;
    OknoPrzelicz oknoPrzelicz;
    Baza baza;
    String filename;

    public OknoStart(String title, Baza baza) throws HeadlessException {
        super(title);
        this.baza = baza;
        this.filename = "baza.dat";
        oknoFigura = null;
        oknoInfo = null;
        setSize(300,350);
        menuBar = new MenuBar();
        menuPlik = new Menu("Plik");
        menubaza = new Menu("Baza");
        menuItemWczytaj = new MenuItem("Wczytaj");
        menuItemZapisz = new MenuItem("Zapisz");
        menuItemNowa = new MenuItem("Nowa");
        menuItemCzysc= new MenuItem("Czyść");
        menuItemPrzelicz = new MenuItem("Przelicz");
        labelLista = new Label("Figury");
        labelChoice = new Label("Wybierz FIGURE");
        listaFigur = new List();
        choiceFigury = new Choice();
        choiceFigury.add("Kwadrat");
        choiceFigury.add("Koło");
        choiceFigury.add("Trójkąt");
        choiceFigury.add("Prostokąt");
        buttonDodaj = new Button("DODAJ");
        buttonUsun = new Button("USUŃ");
        buttonInfo = new Button("INFO");

        menuBar.add(menuPlik);
        menuBar.add(menubaza);
        menuPlik.add(menuItemNowa);
        menuPlik.add(menuItemZapisz);
        menuPlik.add(menuItemWczytaj);
        menubaza.add(menuItemCzysc);
        menubaza.add(menuItemPrzelicz);
        setMenuBar(menuBar);
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        gb.gridx = 0;
        gb.gridy = 0;
        add(labelLista,gb);
        gb.gridx = 1;
        gb.gridy = 0;
        add(labelChoice,gb);
        gb.gridx = 0;
        gb.gridy = 1;
        gb.gridheight = 4;
        gb.ipadx = gb.ipady = 5;
        gb.insets = new Insets(10,10,10,10);
        gb.fill = GridBagConstraints.VERTICAL;
        add(listaFigur,gb);
        gb.gridheight = 1;
        gb.gridx = 1;
        gb.gridy = 1;
        add(choiceFigury,gb);
        gb.gridx = 1;
        gb.gridy = 2;
        add(buttonDodaj,gb);
        gb.gridx = 1;
        gb.gridy = 3;
        add(buttonUsun,gb);
        gb.gridx = 1;
        gb.gridy = 4;
        add(buttonInfo,gb);

        buttonDodaj.addActionListener(e -> addFigura());

        buttonInfo.addActionListener(e -> infoFigura());

        buttonUsun.addActionListener(e -> deleteFigura());

        menuItemCzysc.addActionListener(e -> czyscBaze());

        menuItemPrzelicz.addActionListener(e -> przeliczBaze());

        menuItemZapisz.addActionListener(e -> zapiszBaze(filename));

        menuItemWczytaj.addActionListener(e -> wczytajBaze(filename));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        setVisible(true);
    }

    private void addFigura() {
        if (oknoFigura == null) {
            //oknoFigura = new OknoFigura("Podaj dane Figury", this);
            switch (choiceFigury.getSelectedItem()){
                case "Kwadrat" :
                    oknoFigura = new OknoKwadrat("Podaj dane kwadratu",this);
                    break;
                case "Koło" :
                    oknoFigura = new OknoKolo("Podaj dane koła",this);
                    break;
                case "Trójkąt" :
                    oknoFigura = new OknoTrojkat("Podaj dane trójkąta",this);
                    break;
                case "Prostokąt" :
                    oknoFigura = new OknoProstokat("Podaj dane prostokata",this);
                    break;
                default:
            }
            if (oknoFigura != null)
                setEnabled(false);
        }

    }

    private void infoFigura() {
        int index = listaFigur.getSelectedIndex();
        if (index >= 0) {
            Figura f = baza.get(index);
            oknoInfo = new OknoInfo("Informacje o figurze", f, this);
            setEnabled(false);
        }
    }

    private void deleteFigura() {
        int index = listaFigur.getSelectedIndex();
        if (index >= 0) {
            baza.delete(index);
            listaFigur.remove(index);
        }
    }

    private void czyscBaze() {
        baza.purge();
        listaFigur.removeAll();
    }

    private void przeliczBaze() {
        Vector<Figura> figury = baza.getAll();
        Double pole = 0.0;

        if(figury.isEmpty())
            return;

        for (int i = 0; i < figury.size(); i++) {
            Figura f = baza.get(i);
            pole += f.getPole();
        }

        new OknoPrzelicz("Pole wszystkich figur", pole, this);
        setEnabled(false);
    }

    private void zapiszBaze(String filename) {
        baza.zapisz(filename);
    }

    private void wczytajBaze(String filename) {
        baza.wczytaj(filename);
        listaFigur.removeAll();
        Vector<Figura> figury = baza.getAll();
        for (int i = 0; i < figury.size(); i++) {
            listaFigur.add(figury.get(i).getNazwa());
        }
    }

    public void dodajFigure(boolean zapisz) {
        if (zapisz) {
            Figura f = oknoFigura.getFigura();
            listaFigur.add(f.getNazwa());
            baza.add(f);
        }
        oknoFigura.dispose();
        oknoFigura = null;
        setEnabled(true);
    }


}
