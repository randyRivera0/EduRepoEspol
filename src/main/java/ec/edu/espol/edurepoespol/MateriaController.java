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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


/**
 * FXML Controller class
 *
 * @author PERSONAL
 */
public class MateriaController implements Initializable {
    
    @FXML
    Text nombreMateria;
    @FXML
    Text codigoMateria;
    @FXML
    VBox material;
    @FXML
    Button paginaInicio;
    @FXML
    Button misDescargas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
