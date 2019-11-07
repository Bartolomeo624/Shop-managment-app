package Bartek;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * klasa z GUI odpowiedzialna za zbieranie potrzebnych danych do stworzenia i wyswielenia faktury.
 */
public class GUIOkno {

    //komponenty GUI
   private static BazaArtykulow baza = new BazaArtykulow();
   private static ArrayList<Towar> zamowienie;
   private static ChoiceBox wybortowaru = new ChoiceBox();
   private static TextField Tilosc = new TextField();
   private static TextField Tnazwa1 = new TextField();
   private static TextField Tnazwa2 = new TextField();
   private static TextField Tadres1 = new TextField();
   private static TextField Tadres2 = new TextField();
   private static TextField Tkodpocz1 = new TextField();
   private static TextField Tkodpocz2 = new TextField();
   private static TextField Tmiasto1 = new TextField();
   private static TextField Tmiasto2 = new TextField();
   private static TextField TNIP1 = new TextField();
   private static TextField TNIP2 = new TextField();
   private static TextField Tnumfakt = new TextField();
   private static TextField Tmsc_wyst = new TextField();
   private static TextField Tdwyst = new TextField();
   private static TextField Tdzak = new TextField();
   private static TextField Ttermin = new TextField();
   private static TextField Tforma = new TextField();
   public static Faktura faktura;
   private static Stage window;

    public static Faktura display() {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Wpisywanie danych");
        window.setFullScreen(true);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //********************************************************************
        // odczyt nazwy firmy sprzedajacej i klienta

        Label Lnazwa = new Label("Nazwa firmy:");
        GridPane.setConstraints(Lnazwa, 0, 0);

        //Tnazwa1
        Tnazwa1.setPromptText("sprzedajacy");
        GridPane.setConstraints(Tnazwa1, 1, 0);

        //Tnazwa2
        Tnazwa2.setPromptText("klient");
        GridPane.setConstraints(Tnazwa2, 3, 0);

        //********************************************************************
        // odczyt adresów obu firm

        Label Ladres = new Label("Adres firmy:");
        GridPane.setConstraints(Ladres, 0, 1);

        //Tadres1
        Tadres1.setPromptText("sprzedajacy");
        GridPane.setConstraints(Tadres1, 1, 1);

        //Tadres2
        Tadres2.setPromptText("klient");
        GridPane.setConstraints(Tadres2, 3, 1);

        //********************************************************************
        // odczyt kodow pocztowych obu firm

        Label Lkodpocz = new Label("Kod pocztowy:");
        GridPane.setConstraints(Lkodpocz, 0, 2);

        //Tkodpocz1
        Tkodpocz1.setPromptText("sprzedajacy");
        GridPane.setConstraints(Tkodpocz1, 1, 2);

        //Tkodpocz2
        Tkodpocz2.setPromptText("klient");
        GridPane.setConstraints(Tkodpocz2, 3, 2);

        //********************************************************************
        // odczyt miast obu firm

        Label Lmiasto = new Label("Miasto:");
        GridPane.setConstraints(Lmiasto, 0, 3);

        //Tmiasto1
        Tmiasto1.setPromptText("sprzedajacy");
        GridPane.setConstraints(Tmiasto1, 1, 3);

        //Tmiasto2
        Tmiasto2.setPromptText("klient");
        GridPane.setConstraints(Tmiasto2, 3, 3);

        //********************************************************************
        // odczyt NIPow obu firm

        Label LNIP = new Label("NIP:");
        GridPane.setConstraints(LNIP, 0, 4);

        //TNIP1
        TNIP1.setPromptText("sprzedajacy");
        GridPane.setConstraints(TNIP1, 1, 4);

        //TNIP2
        TNIP2.setPromptText("klient");
        GridPane.setConstraints(TNIP2, 3, 4);

        //dodanie elementów do gridu
        grid.getChildren().addAll(Ladres,Lkodpocz,Lmiasto,Lnazwa,LNIP,Tadres1,Tadres2,Tkodpocz1,Tkodpocz2,Tmiasto1,Tmiasto2,Tnazwa1,Tnazwa2,TNIP1,TNIP2);

        //***********************************************************
        //Dodawanie zamowionego towaru do faktury

        Label Ltowar = new Label("Towar:");
        GridPane.setConstraints(Ltowar, 0, 6);

        //wybortowaru
        wybortowaru = new ChoiceBox();
        GridPane.setConstraints(wybortowaru,3,6);
        wybortowaru.getItems().addAll(baza.nazwyArt);

        //Tilosc
        Tilosc.setPromptText("ilosc");
        GridPane.setConstraints(Tilosc, 1, 6);

        Button Bdodaj = new Button("Dodaj");
        GridPane.setConstraints(Bdodaj, 4, 6);

        zamowienie = new ArrayList<Towar>();
        Bdodaj.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for(Artykul art : baza.daneArt) {
                    if(wybortowaru.getValue().equals(art.nazwa)) {
                        zamowienie.add(new Towar(art,Double.parseDouble(Tilosc.getText())));
                        System.out.println("dodano: "+Tilosc.getText()+" "+ art.jednostka+" "+art.nazwa);
                    }
                }
            }
        });
        //dodawanie do gridu
        grid.getChildren().addAll(Tilosc,Ltowar,wybortowaru,Bdodaj);

        //***********************************************************
        // pobieranie daych o numerze faktury i miejscu wystawienia

        Label Lnummsc = new Label("Numer faktury i miejsce wystawienia:");
        GridPane.setConstraints(Lnummsc, 0, 7);

        //Tnumfakt
        Tnumfakt.setPromptText("numer faktury");
        GridPane.setConstraints(Tnumfakt, 1, 7);

        //Tmsc_wyst
        Tmsc_wyst.setPromptText("miejsce wystawienia");
        GridPane.setConstraints(Tmsc_wyst, 3, 7);

        //***********************************************************
        // pobieranie daych o  dacie wystawienia i zakonczenia

        Label Ldaty = new Label("Data wystawienia i zakonczenia:");
        GridPane.setConstraints(Ldaty, 0, 8);

        //Tdwyst
        Tdwyst.setPromptText("data wystawienia");
        GridPane.setConstraints(Tdwyst, 1, 8);

        //Tdzak
        Tdzak.setPromptText("data zakonczenia");
        GridPane.setConstraints(Tdzak, 3, 8);

        //***********************************************************
        // pobieranie daych o terminie i formie platnosci

        Label Ltermin_forma = new Label("Termin i forma platnosci:");
        GridPane.setConstraints(Ltermin_forma, 0, 9);

        //Ttermin
        Ttermin.setPromptText("termin platnosci");
        GridPane.setConstraints(Ttermin, 1, 9);

        //Tforma
        Tforma.setPromptText("forma platnosci");
        GridPane.setConstraints(Tforma, 3, 9);


        //***********************************************************
        // dodawanie przycisku tworzenia faktury i jego funkcjonalnosci

        Button Bfaktura = new Button("Stworz fakture");
        GridPane.setConstraints(Bfaktura, 3, 11);

        Bfaktura.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                //tworzymy dwa obiekty klasy firma potrzebne do stworzenia faktury
                Firma Fsprz = new Firma(Tnazwa1.getText(),Tadres1.getText(),Tkodpocz1.getText(),Tmiasto1.getText(),TNIP1.getText());
                Firma Fkli = new Firma(Tnazwa2.getText(),Tadres2.getText(),Tkodpocz2.getText(),Tmiasto2.getText(),TNIP2.getText());
                //uzywamy danych wpisanych w pola tekstowe, listy zamowien i obiektow klasy firma do stworzenia obiektu klasy faktura
                faktura = new Faktura(Tnumfakt.getText(),Tmsc_wyst.getText(),Tdwyst.getText(),Tdzak.getText(),Ttermin.getText(),Tforma.getText(),Fkli,Fsprz,zamowienie);
                //drukujemy fakture w konsoli
                faktura.drukuj_fakture();
            }

        });

        Button Bexit = new Button("wyjdz");
        GridPane.setConstraints(Bexit, 3, 14);

        Bexit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Tilosc.clear();
                Tnazwa1.clear();
                Tnazwa2.clear();
                Tadres1.clear();
                Tadres2.clear();
                Tkodpocz1.clear();
                Tkodpocz2.clear();
                Tmiasto1.clear();
                Tmiasto2.clear();
                TNIP1.clear();
                TNIP2.clear();
                Tnumfakt.clear();
                Tmsc_wyst.clear();
                Tdwyst.clear();
                Tdzak.clear();
                Ttermin.clear();
                Tforma.clear();
                window.close();
            }
        });
        grid.getChildren().addAll(Lnummsc,Ldaty,Ltermin_forma,Tnumfakt,Tmsc_wyst,Tdwyst,Tdzak,Ttermin,Tforma,Bfaktura,Bexit);

        // dodawanie

        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);
        window.showAndWait();
        return faktura;
    }
}
