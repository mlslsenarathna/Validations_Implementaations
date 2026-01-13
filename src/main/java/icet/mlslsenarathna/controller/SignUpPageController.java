package icet.mlslsenarathna.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpPageController implements Initializable {

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

    }

    @FXML
    void txtEmailAddressOnAction(KeyEvent event) {

    }

    @FXML
    void txtReEnterPasswordOnAction(KeyEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
