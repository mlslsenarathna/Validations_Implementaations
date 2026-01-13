package icet.mlslsenarathna.controller;

import com.jfoenix.controls.JFXButton;
import icet.mlslsenarathna.model.dto.UserDTO;
import icet.mlslsenarathna.service.AuthenticationService;
import icet.mlslsenarathna.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
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
        try {
            Stage stage = (Stage) this.btnCancle.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/SignInPageView.fxml"));
            Parent root =loader.load();
            SignInPageController signInPageController = loader.getController();
            stage.setScene(new Scene(root));
            //stage.setFullScreen(true);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) {
       UserDTO newUser=getUserDetails();
       if(userService.registerNewUser(newUser)){
           JOptionPane.showMessageDialog(null,"Registered Successfully!");
           try {
           Stage stage = (Stage) this.btnSignUp.getScene().getWindow();
           FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/SignInPageView.fxml"));
           Parent root =loader.load();
           SignInPageController signInPageController = loader.getController();
           stage.setScene(new Scene(root));
           //stage.setFullScreen(true);
           stage.show();
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
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
