package ec.edu.espol.edurepoespol;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InicioController {
    
    String data;
    
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
    Button salir;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("materia");
    }
    
    @FXML
    private void handleSearchFiles() throws IOException {
        String subjectId = codigo.getText();
        if (subjectId.isEmpty()) {
            showAlert("Error", "Subject ID cannot be empty.");
            return;
        }

        try {
            // Establish connection to the database (adjust URL, user, and password)
            Connection connection = DataBaseConnection.getInstance().getConnection();

            // Prepare the SQL query
            String query = "SELECT * FROM archivo WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, subjectId);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Process the results
            StringBuilder result = new StringBuilder("Files for Subject ID " + subjectId + ":\n");
            while (resultSet.next()) {
                // Assuming 'file_name' is a column in your 'files' table
                String fileName = resultSet.getString("nombre");
                result.append(fileName).append("\n");
            }
            
            data = result.toString();

            // Show results in an alert
            showAlert("Search Results", result.toString());

            // Close resources
            resultSet.close();
            statement.close();
            
            switchScene();

        } catch (SQLException e) {
            showAlert("Database Error", "An error occurred while accessing the database: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
     @FXML
    private void switchScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("materia.fxml"));
            Parent root = loader.load();

            // Get the next scene's controller
            MateriaController nextSceneController = loader.getController();

            // Pass data to the next scene
            
            nextSceneController.initializeData(data);

            // Switch the scene
             Stage stage = (Stage) codigo.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to show alerts
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    @FXML
    private void handleBackButtonAction(ActionEvent event) {
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
