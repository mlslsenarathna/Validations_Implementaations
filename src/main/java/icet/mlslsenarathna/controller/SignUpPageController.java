package icet.mlslsenarathna.controller;

import com.jfoenix.controls.JFXButton;
import icet.mlslsenarathna.model.dto.UserDTO;
import icet.mlslsenarathna.service.AuthenticationService;
import icet.mlslsenarathna.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpPageController implements Initializable {
    AuthenticationService authenticationService=new AuthenticationService();
    UserService userService=new UserService();

    @FXML
    private JFXButton btnCancle;

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private TextField txtEmailAddress;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private PasswordField txtPassowrd;

    @FXML
    private PasswordField txtReEnterPassword;

    @FXML
    void btnCancleOnAction(ActionEvent event) {

    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) {
       UserDTO newUser=getUserDetails();
       if(userService.registerNewUser(newUser)){
           JOptionPane.showMessageDialog(null,"Registered Successfully!");
       }

    }

    private UserDTO getUserDetails() {
        return new UserDTO(
                txtFirstName.getText().trim(),
                txtLastName.getText().trim(),
                txtEmailAddress.getText().trim(),
                txtPassowrd.getText().trim()
        );
    }

    @FXML
    void txtEmailAddressOnAction(KeyEvent event) {


    }

    @FXML
    void txtReEnterPasswordOnAction(KeyEvent event) {
        if (authenticationService.isMatchePassword(txtPassowrd.getText().trim(),txtReEnterPassword.getText().trim())){
          if(authenticationService.isValidGmail(txtEmailAddress.getText().trim())){
              btnSignUp.setDisable(false);
          }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
