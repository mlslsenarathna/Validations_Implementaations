package icet.mlslsenarathna.controller;

import com.jfoenix.controls.JFXButton;
import icet.mlslsenarathna.service.AuthenticationService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInPageController  implements Initializable {
    AuthenticationService authenticationService=new AuthenticationService();

    @FXML
    private JFXButton btnLogIn;

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void btnLogInOnAction(ActionEvent event) {
        String userMail=txtEmail.getText().trim();
        String pword=txtPassword.getText().trim();
        if(authenticationService.isValidGmail(userMail)){
            if(pword!=null){
                authenticationService.checkEmailAndPassword(userMail,pword);


            }


        }

    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
