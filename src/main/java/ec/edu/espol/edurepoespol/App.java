package ec.edu.espol.edurepoespol;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        
        // Insert the new administrador record into the database
        try {
                       
            AdministradorDAO administradorDAO = new AdministradorDAO();
            // Create a new Administrador object
            Administrador administrador1 = new Administrador("rariberm@espol.edu.ec", 1);

            administradorDAO.insert(administrador1);
            administradorDAO.getAll();
            System.out.println("Administrador inserted successfully.");
 
        
            List<Administrador> administradores = administradorDAO.getAll();
            for (Administrador administrador : administradores) {
                System.out.println(administrador.getCorreo());
            }

        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        launch();
    }

}