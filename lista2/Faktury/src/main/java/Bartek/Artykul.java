package Bartek;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Klasa przedstawiajaca artykul dostepny do zakupu
 */
public class Artykul {

    protected String nazwa;
    protected String kod;
    protected String jednostka;
    protected double VAT;
    protected double cena_netto;
    protected double cena_brutto;

    /**
     * Konstruktor tworzy obiekt Artykul i oblicza cene brutto artykulu.
     * @param nazwa nazwa artykulu
     * @param kod unikalny kod artykulu
     * @param jednostka jednostka w ktorej mierzy sie ilosc danego artykulu
     * @param VAT podatek VAT nalozony na artykul
     * @param cena_netto cena netto - nieobciazona podatkiem VAT
     */
    public Artykul(String nazwa, String kod, String jednostka, double VAT, double cena_netto) {
        this.nazwa = nazwa;
        this.kod = kod;
        this.jednostka = jednostka;
        this.VAT = VAT;
        this.cena_netto = cena_netto;
        this.cena_brutto = round( cena_netto * (1.0 + VAT),2);

    }

    /**
     * przybliza lizcbe zmiennoprzecinkowa do dowolnej liczby miejsc po przecinku
     * @param value zaokraglana wartosc
     * @param places pozadana liczba miejsc po przecinku
     * @return zaokraglona wartosc
     */
    protected static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}

