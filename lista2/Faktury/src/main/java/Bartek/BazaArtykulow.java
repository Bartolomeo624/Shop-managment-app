package Bartek;

import java.util.ArrayList;

/**
 * Klasa zawierajaca liste i obslugujaca wszystkie artykuly
 */
public class BazaArtykulow {

    /**
     * Lista wszystkich artykulow dostepnych do sprzedazy.
     */
    public ArrayList<Artykul> daneArt = new ArrayList<Artykul>();
    /**
     * lista nazw wszystkich artykulow
     */
    public ArrayList<String> nazwyArt = new ArrayList<String>();

    Artykul a1 = new Artykul("Cegła","a_001","szt.",0.08,7.49);
    Artykul a2 = new Artykul("Drabina","b_001","szt.",0.23,89.99);
    Artykul a3 = new Artykul("Cement","a_002","kg",0.08,3.59);
    Artykul a4 = new Artykul("Mlotek","b_002","szt.",0.23,24.99);
    Artykul a5 = new Artykul("Wiertarka","b_003","szt.",0.23,195.00);
    Artykul a6 = new Artykul("Profil metlowy","a_003","szt.",0.08,16.00);
    Artykul a7 = new Artykul("Farba","a_004","litr",0.08,8.00);


    public BazaArtykulow(){
        daneArt.add(a1);
        daneArt.add(a2);
        daneArt.add(a3);
        daneArt.add(a4);
        daneArt.add(a5);
        daneArt.add(a6);
        daneArt.add(a7);

        for (Artykul a: daneArt) {
            nazwyArt.add(a.nazwa);
        }
    }

    private void dodaj_artykul(Artykul art) {
        daneArt.add(art);
        nazwyArt.add(art.nazwa);
    }
}
