package Bartek;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Klasa GUI bedaca podstawowym menu aplikacji. Umozliwia dodanie nowej faktury i wyswietlenie stworzonej wczesniej faktury.
 */
public class GUIFaktury extends Application {

    private ArrayList<Faktura> listaFaktur = new ArrayList<>();
    private ArrayList<String> listaNrFaktur = new ArrayList<>();
    private Faktura aktualnaFaktura;
    private Button button;
    private Button button2;
    private static ChoiceBox Cwyborfaktury = new ChoiceBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        primaryStage.setTitle("Tworzenie faktur");
        button = new Button("Nowa faktura");
        GridPane.setConstraints(button, 0, 0);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               aktualnaFaktura = GUIOkno.display();
                listaFaktur.add(aktualnaFaktura);
                listaNrFaktur.add(aktualnaFaktura.getNumer_faktury());
                Cwyborfaktury.getItems().add(aktualnaFaktura.getNumer_faktury());
                System.out.println(listaFaktur.size());
            }
        });

        GridPane.setConstraints(Cwyborfaktury,1,2);

        button2 = new Button("pokaz fakture");
        GridPane.setConstraints(button2, 2, 2);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for (String numer:listaNrFaktur) {
                    if (numer.equals(Cwyborfaktury.getValue())) {
                        for (Faktura faktura:listaFaktur) {
                            if (numer.equals(faktura.getNumer_faktury())) {

                                faktura.drukuj_fakture();
                            }
                        }
                    }
                }
            }
        });

        grid.getChildren().addAll(button,Cwyborfaktury,button2);
        Scene scene = new Scene(grid, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void dodajFakture(Faktura faktura) {
        listaFaktur.add(GUIOkno.faktura);
    }


}
