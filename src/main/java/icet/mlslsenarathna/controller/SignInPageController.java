package icet.mlslsenarathna.controller;

import com.jfoenix.controls.JFXButton;
import icet.mlslsenarathna.model.dto.AuthenticationDTO;
import icet.mlslsenarathna.service.AuthenticationService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
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
        AuthenticationDTO authenticationDTO=new AuthenticationDTO(
                userMail,
                pword
        );
        if(authenticationService.isValidGmail(userMail)){
            if(pword!=null){
                if(authenticationService.checkEmailAndPassword(authenticationDTO)){
                    try {
                        Stage stage = (Stage) this.btnLogIn.getScene().getWindow();
                        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/HomePageView.fxml"));
                        Parent root =loader.load();
                        HomePageViewController homePageViewController = loader.getController();
                        homePageViewController.transferData(txtEmail.getText().trim());
                        stage.setScene(new Scene(root));
                        //stage.setFullScreen(true);
                        stage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

//
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid password");
                }
            }

        }else {
            JOptionPane.showMessageDialog(null,"Invalid Email Informations ");

        }

    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) {
        try {
            Stage stage = (Stage) this.btnSignUp.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/SignUpPageView.fxml"));
            Parent root =loader.load();
            SignUpPageController signUpPageController = loader.getController();
            stage.setScene(new Scene(root));
            //stage.setFullScreen(true);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
