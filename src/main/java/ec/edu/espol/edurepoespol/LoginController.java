package ec.edu.espol.edurepoespol;

import java.io.IOException;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("inicio");
    }
}