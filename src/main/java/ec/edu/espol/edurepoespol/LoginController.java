package ec.edu.espol.edurepoespol;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    
    @FXML
    TextField usuario;
    @FXML
    PasswordField password;
    @FXML
    Button entrar;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("inicio");
    }
}