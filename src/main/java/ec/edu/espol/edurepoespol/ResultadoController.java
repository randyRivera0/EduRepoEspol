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
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    @FXML
    Button regresar;
    @FXML
    Button salir;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        @FXML
    private void handleBackButtonAction(ActionEvent event) {
        try {
            // Cargar la ventana anterior desde su archivo FXML
            Parent ventanaAnterior = FXMLLoader.load(getClass().getResource("materia.fxml"));

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
