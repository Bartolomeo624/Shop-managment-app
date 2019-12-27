package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class LoginController {

    @FXML
    private TextField TFlogin;

    @FXML
    private TextField TFpassword;

    @FXML
    private Text TwrongData;

    @FXML
    private Button okButton;

    public void signIn(ActionEvent actionEvent) throws IOException {
        URL url = new File("").toURI().toURL();
        Parent menu = FXMLLoader.load(url);
        Scene tableViewScene = new Scene(menu);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
}
