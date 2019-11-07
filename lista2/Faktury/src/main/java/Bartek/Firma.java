package Bartek;

/**
 * Klasa przedstawiajaca dane firmy, ktora moze wystawiac fakture jako sprzedawca lub
 * odbierac fakture jako klient
 */
public class Firma {

    private String nazwa_firmy;
    private String adres;
    private String kod_pocztowy;
    private String miasto;
    private String NIP;

    /**
     * Konstruktor tworzy firme i uzupelnia wszystkie informacje
     * @param nazwa_firmy pelna nazwa firmy
     * @param adres adres firmowy
     * @param kod_pocztowy kod pocztowy firmy
     * @param miasto miasto siedziby firmy
     * @param NIP numer identyfikacji podatkowej
     */
    public Firma(String nazwa_firmy, String adres, String kod_pocztowy, String miasto, String NIP) {
        this.nazwa_firmy = nazwa_firmy;
        this.adres = adres;
        this.kod_pocztowy = kod_pocztowy;
        this.miasto = miasto;
        this.NIP = NIP;
    }


    // gettery i settry

    public String getNazwa_firmy() {
        return nazwa_firmy;
    }

    public void setNazwa_firmy(String nazwa_firmy) {
        this.nazwa_firmy = nazwa_firmy;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }
}
