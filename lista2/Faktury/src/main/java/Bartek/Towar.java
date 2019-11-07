package Bartek;

/**
 * Klasa przedstawia konkretna pozycje zamowienia na fakturze. Towar to pewna ilosc artykulow.
 */
public class Towar extends Artykul {

    private Artykul art;
    public double ilosc;
    public double wartosc_netto;
    public double wartosc_brutto;

    /**
     *Konstruktor tworzy obiekt Towar i oblicza wartosci netto oraz brutto danej pozycji
     * @param art typ artykulu
     * @param ilosc ilosc artykulow
     */
   public Towar(Artykul art, double ilosc) {
       super(art.nazwa, art.kod, art.jednostka, art.VAT, art.cena_netto);
       this.art = art;
       this.ilosc = ilosc;
       this.wartosc_netto = round(ilosc * art.cena_netto,2);
       this.wartosc_brutto = round(ilosc * art.cena_brutto,2);
   }
}
