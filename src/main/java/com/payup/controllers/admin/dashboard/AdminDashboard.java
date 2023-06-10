package com.payup.controllers.admin.dashboard;

import com.payup.models.Admin;
import com.payup.models.Bank;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.IOException;

public class AdminDashboard {
    @FXML
    Text newClientLabel;

    @FXML
    AnchorPane fragementContainer;

    @FXML
    Text newCardLabel;

    @FXML
    TextField first_name;

    @FXML
    TextField last_name;

    @FXML
    TextField username;

    @FXML
    PasswordField password;

    @FXML
    TextField accountNum;

    @FXML
    PasswordField accountPass;

    @FXML
    TextField balance;

    @FXML
    TextField type;


    //Add New Card TextFields
    @FXML
    TextField client_username;
    @FXML
    TextField client_password;
    @FXML
    TextField new_card_account_num;
    @FXML
    TextField new_card_password;
    @FXML
    TextField new_card_balance;
    @FXML
    TextField new_card_type;


    @FXML
    void addNewClient(ActionEvent event) throws IOException {
        String fname = first_name.getText();
        String lname = last_name.getText();
        String uname = username.getText();
        String pass = password.getText();
        String accountNumber = accountNum.getText();
        String accountPassword = accountPass.getText();
        String b = balance.getText();
        String t = type.getText();

        if(fname.isEmpty() || lname.isEmpty() || uname.isEmpty() || pass.isEmpty() || accountNumber.isEmpty() ||
        accountPassword.isEmpty() || b.isEmpty() || t.isEmpty()){



        }else{
            try{
                double myBalance = Double.parseDouble(b);
                boolean accountNumFound = false;
                boolean usernameFound = false;

                for(int i = 0; i < Bank.getClients().size(); i++){
                    if(uname.equals(Bank.getClients().get(i))){
                        usernameFound = true;
                    }
                }

                for(int i = 0; i < Bank.getClients().size(); i++){
                    for(int j = 0; j < Bank.getClients().get(i).getAccounts().size(); j++){
                        if(accountNumber.equals(Bank.getClients().get(i).getAccounts().get(j).getAccountNumber())){
                            accountNumFound = true;
                        }
                    }
                }

                if(usernameFound){
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error");
                    a.setContentText("A Client with this username has been found, try again with a unique username");
                    a.showAndWait();
                }else{
                    if(accountNumFound){
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Error");
                        a.setContentText("A Client with this account number has been found, try again with a unique account number");
                        a.showAndWait();


                    }else{
                        Admin.addNewClient(fname, lname, uname, pass, accountNumber, myBalance, accountPassword, t);
                        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                        a.setTitle("Success");
                        a.setContentText("Client Added Successfully");
                        a.showAndWait();
                        AnchorPane lol = FXMLLoader.load(getClass().getResource("/layout/home_admin.fxml"));
                        fragementContainer.getChildren().setAll(lol);
//                      Null Pointer Exception when following line is uncommented
//                        newClientLabel.setFont(Font.font(null,FontWeight.NORMAL,15));
                    }
                }
            }catch(NumberFormatException e){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setContentText("Please type a number in the balance field");
                a.showAndWait();
            }
        }



    }


    @FXML
    void onNewClientClicked(MouseEvent event) throws IOException {
        AnchorPane newClientPane = FXMLLoader.load(getClass().getResource("/layout/add_client.fxml"));
        fragementContainer.getChildren().setAll(newClientPane);
        newClientLabel.setFont(Font.font(null,FontWeight.BOLD,15));
        newCardLabel.setFont(Font.font(null,FontWeight.NORMAL,15));

    }


    @FXML
    void onNewCardClicked() throws IOException {
        AnchorPane newCardPane = FXMLLoader.load(getClass().getResource("/layout/add_card.fxml"));
        fragementContainer.getChildren().setAll(newCardPane);
        newClientLabel.setFont(Font.font(null,FontWeight.NORMAL,15));
        newCardLabel.setFont(Font.font(null,FontWeight.BOLD,15));

    }

    @FXML
    void addNewCard(ActionEvent event) throws IOException {
        String username = client_username.getText();
        String clientPassword = client_password.getText();
        String account_num = new_card_account_num.getText();
        String password = new_card_password.getText();
        String balance = new_card_balance.getText();
        String type = new_card_type.getText();

        try{
            double b = Double.parseDouble(balance);
            boolean duplicatePresent = checkAccountNumDuplicate(account_num);

            if(b <= 0){
                throw new NumberFormatException();
            }

            if(!duplicatePresent){
                boolean userVerified = false;
                int client_index = -1;
                for(int i = 0; i < Bank.getClients().size(); i++){
                    if(Bank.getClients().get(i).getUsername().equals(username) && Bank.getClients().get(i).getPassword().equals(clientPassword)){
                        userVerified = true;
                        client_index = i;
                        break;
                    }
                }

                if(userVerified){
                    Bank.getClients().get(client_index).addAccount(account_num, b, password, type);
                    AnchorPane lol = FXMLLoader.load(getClass().getResource("/layout/home_admin.fxml"));
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setTitle("Success");
                    a.setContentText("Card added Successfully");
                    a.showAndWait();
//                    Null Pointer Exception when following line is uncommented
//                        newCardLabel.setFont(Font.font(null,FontWeight.NORMAL,15));
                    fragementContainer.getChildren().setAll(lol);
                }else{
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error");
                    a.setContentText("Please type a valid username and password");
                    a.showAndWait();
                }
            }else{
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setContentText("Please type a unique account number");
                a.showAndWait();
            }

        }catch(NumberFormatException e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setContentText("Please type a valid number in the balance field");
            a.showAndWait();
        }

    }

    boolean checkAccountNumDuplicate(String accountNum){
        for(int i = 0; i < Bank.getClients().size(); i++){
            for(int j = 0; j < Bank.getClients().get(i).getAccounts().size(); j++){
                if(accountNum.equals(Bank.getClients().get(i).getAccounts().get(j).getAccountNumber())){
                    return true;
                }
            }
        }
        return false;
    }

    @FXML
    void onprofileclickd(MouseEvent event) throws IOException {
        AnchorPane lol = FXMLLoader.load(getClass().getResource("/layout/admin_profile_page.fxml"));
        fragementContainer.getChildren().setAll(lol);
    }
}
