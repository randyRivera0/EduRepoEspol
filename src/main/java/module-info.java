module ec.edu.espol.edurepoespol {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens ec.edu.espol.edurepoespol to javafx.fxml;
    exports ec.edu.espol.edurepoespol;
}
