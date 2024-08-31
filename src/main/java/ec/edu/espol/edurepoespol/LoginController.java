package ec.edu.espol.edurepoespol;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    
    @FXML
    TextField usuario;
    @FXML
    PasswordField password;
    @FXML
    Button entrar;

    @FXML
    private void switchToPrimary() throws IOException {
        String email = usuario.getText();
        UserDAO userDao = new UserDAO();
        User user;
            try{
                user = userDao.getByEmail(email);
                if(user.isProfesor() || user.isTeachingAssistant()){
                App.setRoot("admin");
            }
    //        AdministradorDAO administradorDAO = new AdministradorDAO();
    //        administradorDAO.getById(0);
            else{
                App.setRoot("inicio");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
