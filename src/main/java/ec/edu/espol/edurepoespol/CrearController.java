/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.edurepoespol;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PERSONAL
 */
public class CrearController implements Initializable {

    String nombreA;
    
    @FXML
    TextField nombre;
    @FXML
    TextField codigo;
    @FXML
    Button subirArchivo;
    @FXML
    Button crear;
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
            Parent ventanaAnterior = FXMLLoader.load(getClass().getResource("admin.fxml"));

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
    private void insertFile(ActionEvent event){
        Archivo file = new Archivo(nombreA , codigo.getText(), "101");
        FileDAO fileDAO = new FileDAO();
        fileDAO.insert(file);
    }
    
    /*
    @FXML
    private java.io.Archivo openFileChooser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de texto (*.txt)", "*.txt"));
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        return fileChooser.showOpenDialog(stage);
    }
    */
    
    @FXML
    private void openFileChooser(ActionEvent event) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de texto (*.txt)", "*.pdf"));
    
    // Show the file chooser dialog
    Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
    File selectedFile = fileChooser.showOpenDialog(stage);
    
    // If a file was selected, return its name
    if (selectedFile != null) {
        nombreA = selectedFile.getName();  // Get only the file name
    }
}

            
}
