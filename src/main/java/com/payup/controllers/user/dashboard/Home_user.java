package com.payup.controllers.user.dashboard;


import com.payup.models.Account;
import com.payup.models.Bank;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Home_user {
    ArrayList<Account>  accounts = Bank.getCurrentUser().getAccounts()  ;
    static int counter ;


    @FXML
    private Text datelabel;

    @FXML
    private Text hellosign;

    @FXML
    private Label accountnumber;

    @FXML
    private Label accountnumber1;

    @FXML
    public void initialize() {
       counter = 0 ;
        accountnumber1.setText(accounts.get(0).getAccountNumber());
        accountnumber.setText("$" + accounts.get(0).getBalance());
       hellosign.setText("Hello " + Bank.getCurrentUser().getFirstName() +" "+ Bank.getCurrentUser().getLastName()  +", Welcome Back");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMMM-YYYY");
        LocalDateTime now = LocalDateTime.now();
        datelabel.setText(dtf.format(now));
    }

    @FXML
    void nextcardclicked(MouseEvent event) {

        if (Bank.getCurrentUser().accountCount > 1 && counter != Bank.getCurrentUser().accountCount-1){
            counter= counter+1;
            accountnumber1.setText(accounts.get(counter).getAccountNumber());
            accountnumber.setText("$" + accounts.get(counter).getBalance());

        }

    }

    @FXML
    void prevcardclicked(MouseEvent event) {
        if (Bank.getCurrentUser().accountCount > 1 && counter != 0){
            counter= counter-1;
            accountnumber1.setText(accounts.get(counter).getAccountNumber());
            accountnumber.setText("$" + accounts.get(counter).getBalance());

        }

    }

}

