package com.payup.controllers.user.dashboard;

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

public class ProfilePageController implements Initializable {
    @FXML
    TextField first_name;

    @FXML
    TextField last_name;

    @FXML
    TextField client_password;

    @FXML
    TextField card_num;

    @FXML
    TextField current_card_password;

    @FXML
    TextField new_card_password;

    @FXML
    AnchorPane fragmentContainer;


    @FXML
    void update() throws IOException {
        String fname = first_name.getText();
        String lname = last_name.getText();
        String cpassword = client_password.getText();

        String cardNumber = card_num.getText();
        String oldPass = current_card_password.getText();
        String newPass = new_card_password.getText();



        //The user filled in at least one of the 3 card inputs
        if(!cardNumber.isEmpty() || !oldPass.isEmpty() || !newPass.isEmpty()){
            //The user filled all 3 fields
            if(!cardNumber.isEmpty() && !oldPass.isEmpty() && !newPass.isEmpty()){
                int index = Bank.getCurrentUser().findAccount(cardNumber);
                //Card not found
                if(index == -1){
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error");
                    a.setContentText("Card not found");
                    a.showAndWait();
                }else{
                    //Check if password is correct
                    if(Bank.getCurrentUser().getAccounts().get(index).getPassword().equals(oldPass)){
                        Bank.getCurrentUser().getAccounts().get(index).setPassword(newPass);
                        boolean flag = true;
                        if(fname.isEmpty() || lname.isEmpty() || cpassword.isEmpty()){
                            flag = false;
                        }
                        //success
                        updatePersonalInfo(fname, lname, cpassword);
                        if(flag){
                            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                            a.setTitle("Success");
                            a.setContentText("Credentials Updated Successfully");
                            a.showAndWait();
                            AnchorPane newPane = FXMLLoader.load(getClass().getResource("/layout/home_user.fxml"));
                            fragmentContainer.getChildren().setAll(newPane);
                        }

                    }else{
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Error");
                        a.setContentText("Wrong Password, please try again");
                        a.showAndWait();
                    }

                }
            }else{
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error Updating Credentials");
                a.setContentText("Please fill in all card credentials");
                a.showAndWait();
            }
        }else{
            boolean flag = true;
            if(fname.isEmpty() || lname.isEmpty() || cpassword.isEmpty()){
                flag = false;
            }
            updatePersonalInfo(fname, lname, cpassword);
            if(flag){
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setTitle("Success");
                a.setContentText("Credentials Updated Successfully");
                a.showAndWait();
                AnchorPane newPane = FXMLLoader.load(getClass().getResource("/layout/home_user.fxml"));
                fragmentContainer.getChildren().setAll(newPane);
            }

        }


    }

    void updatePersonalInfo(String firstName, String lastName, String password){
        if(firstName.isEmpty() || lastName.isEmpty() || password.isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Updating Credentials");
            a.setContentText("Please fill in all personal information");
            a.showAndWait();
        }else{
            Bank.getCurrentUser().setFirstName(firstName);
            Bank.getCurrentUser().setLastName(lastName);
            Bank.getCurrentUser().setPassword(password);
        }
    }


    @FXML
    void logout(ActionEvent event){
        SceneController.showWelcome(event);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        first_name.setText(Bank.getCurrentUser().getFirstName());
        last_name.setText(Bank.getCurrentUser().getLastName());
        client_password.setText(Bank.getCurrentUser().getPassword());


        System.out.println("Hello");

    }
}
