/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.edurepoespol;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PERSONAL
 */
public class DescargasController implements Initializable {

    @FXML
    Button paginaInicio;
    @FXML
    Button misDescargas;
    @FXML
    VBox material;
    @FXML
    Button salir;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        try {
            // Cargar la ventana anterior desde su archivo FXML
            Parent ventanaAnterior = FXMLLoader.load(getClass().getResource("login.fxml"));

            // Obtener el Stage actual
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Configurar la nueva escena
            Scene scene = new Scene(ventanaAnterior);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
