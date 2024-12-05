package myclass.data;

import java.io.*;
import java.util.Vector;

public class Baza {
    Vector<Figura> figury;

    public Baza() {
        figury = new Vector<Figura>();
    }
    public void add(Figura f){
        figury.add(f);
    }
    public Figura get(int index){
        return figury.get(index);
    }
    public Vector<Figura> getAll(){
        return figury;
    }
    public void delete(int index){
        figury.remove(index);
    }
    public void purge(){
        figury.clear();
    }
    public  void  zapisz(String nazwaPliku){
// zapis bazy za pomoca serializacji obiektu vectora
        try {
            ObjectOutputStream ouS= new ObjectOutputStream(new FileOutputStream(nazwaPliku));
            ouS.writeObject(figury);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void wczytaj(String nazwaPliku){
        // wczytanie bazy za pomoca serializacji obiektu vectora
        try {
            ObjectInputStream oiS = new ObjectInputStream(new FileInputStream(nazwaPliku));
            figury = (Vector<Figura>) oiS.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
