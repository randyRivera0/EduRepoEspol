package ec.edu.espol.edurepoespol;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InicioController {
    
    @FXML
    TextField materia;
    @FXML
    TextField codigo;
    @FXML
    Button buscar;
    @FXML
    Button paginaInicio;
    @FXML
    Button misDescargas;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("materia");
    }
}
