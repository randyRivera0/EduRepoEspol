/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.edurepoespol;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PERSONAL
 */
public class AdminController implements Initializable {

    @FXML
    Button crear;
    @FXML
    Button actualizar;
    @FXML
    BorderPane bp;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        init();
    }    
    public void init() {
        Image image = new Image(getClass().getResourceAsStream("/img/fondo.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(680);
        imageView.setFitHeight(480);
        bp.getChildren().add(0, imageView); // Agregar imagen al fondo    
    }
    @FXML
    public void setSceneDelete(ActionEvent event){
        try {
            App.setRoot("borrar");
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void setSceneCrear(ActionEvent event){
        try {
            App.setRoot("crear");
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    
}
