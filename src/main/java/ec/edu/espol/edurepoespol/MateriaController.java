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
import javafx.scene.text.TextFlow;


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
    @FXML
    TextFlow textFlowFiles;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void initializeData(String data){
        Text text = new Text(data);
        text.setWrappingWidth(400);      // Set wrapping width for the text
        textFlowFiles.getChildren().add(text);
    }
}
