package com.payup.controllers.admin.dashboard;

import com.payup.controllers.SceneController;
import com.payup.models.Bank;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminProfilePageController implements Initializable {
    @FXML
    TextField first_name;

    @FXML
    TextField last_name;

    @FXML
    TextField client_password;


    @FXML
    AnchorPane fragmentContainer;


    @FXML
    void update() throws IOException {
        String fname = first_name.getText();
        String lname = last_name.getText();
        String cpassword = client_password.getText();

        if(fname.isEmpty() || lname.isEmpty() || cpassword.isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Updating Credentials");
            a.setContentText("Please fill in all personal information");
            a.showAndWait();
        }else{
            Bank.getCurrentUser().setFirstName(fname);
            Bank.getCurrentUser().setLastName(lname);
            Bank.getCurrentUser().setPassword(cpassword);

            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Success");
            a.setContentText("Credentials Updated Successfully");
            a.showAndWait();
            AnchorPane newPane = FXMLLoader.load(getClass().getResource("/layout/home_user.fxml"));
            fragmentContainer.getChildren().setAll(newPane);
        }

    }



    @FXML
    void logout(ActionEvent event){
        SceneController.showWelcome(event);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        first_name.setText(Bank.getCurrentAdmin().getFirstName());
        last_name.setText(Bank.getCurrentAdmin().getLastName());
        client_password.setText(Bank.getCurrentAdmin().getPassword());
        System.out.println("Hello");

    }
}
