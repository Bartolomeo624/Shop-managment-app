package Bartek;

import java.util.ArrayList;

/**
 * Klasa odpowiedzialna za ujednolicenie informacji potrzebnych do wygenerowania faktury
 */
public class Faktura {

    private String numer_faktury;
    private String miejsce_wystawienia;
    private String data_wystawienia;
    private String data_zakonczenia;
    private String termin_platnosci;
    private String forma_platnosci;
    private Firma klient;
    private Firma sprzedawca;
    /**
     * Lista zamowionych przez klienta towarow
     */
    private ArrayList<Towar> towary;

    /**
     *
     * @param numer_faktury unikalny numer faktury: "rok/nr"
     * @param miejsce_wystawienia miejsce wystawienia faktury
     * @param data_wystawienia data wydrukowania i wreczenia faktury
     * @param data_zakonczenia data sprzedazy / swiadczenia uslugi
     * @param termin_platnosci termin uiszczenia oplaty za zamowione towary.
     * @param forma_platnosci sposob uiszczenia oplaty np. gotowka, przelew.
     * @param klient firma kupujaca towar.
     * @param sprzedawca firma wystawiajaca fakture.
     * @param towary Lista zamowionych przez klienta towarow.
     */
    public Faktura(String numer_faktury, String miejsce_wystawienia, String data_wystawienia, String data_zakonczenia, String termin_platnosci, String forma_platnosci, Firma klient, Firma sprzedawca, ArrayList<Towar> towary) {
        this.numer_faktury = numer_faktury;
        this.miejsce_wystawienia = miejsce_wystawienia;
        this.data_wystawienia = data_wystawienia;
        this.data_zakonczenia = data_zakonczenia;
        this.termin_platnosci = termin_platnosci;
        this.forma_platnosci = forma_platnosci;
        this.klient = klient;
        this.sprzedawca = sprzedawca;
        this.towary = towary;
    }

    /**
     * Metoda wykorzystuje informacje na temat obu firm, listy zamowionych produktow i danych
     * na temat faktury, aby wygenerowac i sformatowac tekst bedacy gotowa do wydrukowania faktura.
     */
    public void drukuj_fakture() {
        StringBuilder tekst = new StringBuilder();
        double suma_wartnetto = 0;
        double suma_wartbrutto = 0;

        System.out.println("--------------------------------------------------------------------------------------\n");
        System.out.format("%10s%9s\n\n","FAKTURA Nr:",numer_faktury);
        System.out.format("%15s%45s\n\n","SPRZEDAWCA","NABYWCA");
        System.out.format("%15s%45s\n",sprzedawca.getNazwa_firmy(),klient.getNazwa_firmy());
        System.out.format("%15s%45s\n",sprzedawca.getAdres(),klient.getAdres());
        System.out.format("%6s%9s%36s%9s\n",sprzedawca.getKod_pocztowy(),sprzedawca.getMiasto(),klient.getKod_pocztowy(),klient.getMiasto());
        System.out.format("%15s%45s\n\n",sprzedawca.getNIP(),klient.getNIP());
        System.out.println("--------------------------------------------------------------------------------------\n");
        System.out.format("%16s%10s%45s%12s\n","Miejsce wystawienia:",miejsce_wystawienia,"Data wystawienia: ",data_wystawienia);
        System.out.format("%16s%12s%45s%12s\n","Termin platnosci:",termin_platnosci,"Data zakonczenia dostawy: ",data_zakonczenia);
        System.out.format("%16s%12s\n\n","Forma platnosci:",forma_platnosci);
        System.out.println("--------------------------------------------------------------------------------------\n");
        System.out.format("%14s%8s%14s%8s%16s%8s%19s%19s%19s\n\n","|Towar|","|Kod|","|Jednostka|","|Ilosc|","|Cena netto|","|VAT|","|Cena brutto|","|Wartosc Netto|","|Wartosc brutto|");
        for(Towar T : towary) {
            System.out.format("%14s%8s%14s%8s%16s%8s%19s%19s%19s\n",T.nazwa,T.kod,T.jednostka,T.ilosc,T.cena_netto,T.VAT,T.cena_brutto,T.wartosc_netto,T.wartosc_brutto);
            suma_wartnetto += T.wartosc_netto;
            suma_wartbrutto += T.wartosc_brutto;
        }
        System.out.format("\n%106s%19s\n\n","|SUMA NETTO|","|SUMA BRUTTO|");
        System.out.format("%106s%19s\n",suma_wartnetto,suma_wartbrutto);
    }

    public String getNumer_faktury() {
        return numer_faktury;
    }
}
