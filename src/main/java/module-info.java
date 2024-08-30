module ec.edu.espol.edurepoespol {
    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.espol.edurepoespol to javafx.fxml;
    exports ec.edu.espol.edurepoespol;
}
