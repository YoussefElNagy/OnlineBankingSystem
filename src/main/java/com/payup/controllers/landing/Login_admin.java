package com.payup.controllers.landing;


import com.payup.controllers.SceneController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Login_admin {


    @FXML
    private TextField Username;

    @FXML
    private PasswordField passwordField;

    @FXML
    void onLoginButtonClicked(MouseEvent event) {
        System.out.println(Username.getText());
        System.out.println(passwordField.getText());

        if(MONEYBIT.Moneybit.check_admin_cred(Username.getText(),passwordField.getText())){
            System.out.println("Hello");
        SceneController.showadmindash(event);
        }else {
            Alert as = new Alert(Alert.AlertType.ERROR);
            as.setTitle("Invalid Data");
            as.setContentText("Please Try again ");
            as.showAndWait();
        }

    }

    @FXML
    void returnhome(MouseEvent event) {
        SceneController.showWelcome(event);

    }
    @FXML
    public void initialize() {
        Username.setText("joe");
        passwordField.setText("12345");
    }

}
