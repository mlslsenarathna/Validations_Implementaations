package icet.mlslsenarathna.controller;

import com.jfoenix.controls.JFXButton;
import icet.mlslsenarathna.model.dto.UserDTO;
import icet.mlslsenarathna.model.dto.UserDataDTO;
import icet.mlslsenarathna.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageViewController {
    UserService userService=new UserService();

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblFirstName;



    @FXML
    void btnLogOut(ActionEvent event) {
        try {
            Stage stage = (Stage) this.btnLogOut.getScene().getWindow();
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

    public void transferData(String trim) {
        UserDataDTO userDataDTO=userService.getUserDetailsFromEmail(trim);
        String name=userDataDTO.getFirstName()+" "+userDataDTO.getLastName();
        lblFirstName.setText(name);

        lblEmail.setText(userDataDTO.getEmail());


    }
}
