/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.edurepoespol;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author PERSONAL
 */
public class ResultadoController implements Initializable {

    @FXML
    Text facultad;
    @FXML
    Text materia;
    @FXML
    Text codigo;
    @FXML
    Text nombreRecurso;
    @FXML
    Text fechaPublicacion;
    @FXML
    Text autor;
    @FXML
    Text tipoRecurso;
    @FXML
    Text tipoDocumento;
    @FXML
    Text calificacion;
    @FXML
    Button comentarios;
    @FXML
    Button descargar;
    @FXML
    Button paginaInicio;
    @FXML
    Button misDescargas;
    @FXML
    ScrollPane archivo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
