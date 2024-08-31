package ec.edu.espol.edurepoespol;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    
    @FXML
    private void handleSearchFiles() {
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

            // Show results in an alert
            showAlert("Search Results", result.toString());

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            showAlert("Database Error", "An error occurred while accessing the database: " + e.getMessage());
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
}
