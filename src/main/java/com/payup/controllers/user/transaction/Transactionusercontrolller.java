package com.payup.controllers.user.transaction;

import com.payup.models.Account;
import com.payup.models.Bank;
import com.payup.models.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Double.parseDouble;


public class Transactionusercontrolller {
    /*
    * 1 urself
    * 2 pay bills
    * 3  other
    * 4 online purschase
    * */


    //urself
    ArrayList<Account> accounts = Bank.getCurrentUser().getAccounts();

    @FXML
    private TextField accnumur2;

    @FXML
    private TextField acnumur1;
    @FXML
    private TextField amountur;

    // another account



    @FXML
    private TextField usrotheaccnum1;

    @FXML
    private TextField usrotheaccnum2;

    @FXML
    private TextField usrotheaccusr1;

    @FXML
    private TextField usrotheaccusr2;

    @FXML
    private TextField amountother;

    // anline purchases

    @FXML
    private TextField accnumpurs1;

    @FXML
    private TextField accnumpurs2;


    @FXML
    private TextField amountpurs;

    // pay bills

    @FXML
    private TextField accnumbill1;

    @FXML
    private ComboBox<String> combobill;

    @FXML
    private Label amount_paybill;

    ObservableList<String> optionslist ;


//buttons

    @FXML
    private Button butother;

    @FXML
    private Button butpaybill;

    @FXML
    private Button butpurrch;

    @FXML
    private Button butur;


    @FXML
    public void initialize() {
        optionslist =  FXCollections.observableArrayList();
        optionslist.add("Installment Loans");
        optionslist.add("Auto loans");
        optionslist.add("Mortgage loans");
        optionslist.add("Electric bills");
        optionslist.add("Cable bills");
        combobill.setItems(optionslist);





    }

    @FXML
    void comboboxchanged(ActionEvent event) {
        switch (combobill.getValue()){
            case "Installment Loans" :
                amount_paybill.setText("20.00");
                break;
            case "Auto loans" :
                amount_paybill.setText("30.00");
                break;
            case "Mortgage loans" :
                amount_paybill.setText("40.00");
                break;
            case "Electric bills" :
                amount_paybill.setText("50.00");
                break;
            case "Cable bills" :
                amount_paybill.setText("60.00");
                break;

        }


    }


    @FXML
    void paybillbtn(MouseEvent event) {

        if (Objects.equals(accnumbill1.getText().trim(), "" )|| (amount_paybill.getText().isEmpty())
                || (Bank.getCurrentUser().findAccount(accnumbill1.getText().trim()) == -1 )) {

            Alert as = new Alert(Alert.AlertType.ERROR);
            as.setTitle("Invalid Data");
            as.setContentText("Please Try again ");
            as.showAndWait();
        } else {
            double amount = parseDouble(amount_paybill.getText());
            opendialog(accnumbill1.getText().trim(),"", amount, 2);
        }
    }

    @FXML
    void purchasebtn(MouseEvent event) {

    }

    @FXML
    void transfer_to_otheracc(MouseEvent event) {
        if (Objects.equals(usrotheaccnum1.getText().trim(), "") || Objects.equals(usrotheaccnum2.getText().trim(), "") || Objects.equals(usrotheaccusr1.getText().trim(), "")
                ||Objects.equals(usrotheaccusr2.getText().trim(), "")  ||Objects.equals(amountother.getText().trim(), "")
                || (usrotheaccnum1.getText().trim().equals(usrotheaccnum2.getText().trim())
                || (Bank.getCurrentUser().findAccount(usrotheaccnum1.getText().trim()) == -1 || checkotheracc(usrotheaccusr2.getText().trim())  ))) {

            Alert as = new Alert(Alert.AlertType.ERROR);
            as.setTitle("Invalid Data");
            as.setContentText("Please Try again ");
            as.showAndWait();
        } else {
            double amount = parseDouble(amountother.getText());
            opendialog(usrotheaccnum1.getText(),usrotheaccnum2.getText() ,usrotheaccusr2.getText() , amount ,4 );
        }

//        @FXML acc num 1
//        private TextField usrotheaccnum1;
//
//        @FXML acc num 2
//        private TextField usrotheaccnum2;
//
//        @FXML user
//        private TextField usrotheaccusr1;
//
//        @FXML user 2
//        private TextField usrotheaccusr2;
//
//        @FXML
//        private TextField amountother;


    }

    private boolean checkotheracc(String username) {

        Client temp = Bank.getotheruser(username);

        return temp == null;
    }


    @FXML
//    void transfer_to_urself(MouseEvent event) {
//
//        if (Objects.equals(accnumur2.getText().trim(), "") || Objects.equals(acnumur1.getText().trim(), "") || Objects.equals(amountur.getText().trim(), "")) {
//            errorscreen();
//        }else if (accnumur2.getText().trim().equals(acnumur1.getText().trim())){
//            errorscreen();
//        } else if (Bank.getCurrentUser().findAccount(accnumur2.getText().trim()) == -1 || Bank.getCurrentUser().findAccount(acnumur1.getText().trim()) == -1) {
//            errorscreen();
//
//
//            } else {
//                double amount = parseDouble(amountur.getText());
//                // opendialog(accnumur2.getText(),acnumur1.getText(),amount);
//            }
//
//        }

    void transfer_to_urself(MouseEvent event) {

        if (Objects.equals(accnumur2.getText().trim(), "") || Objects.equals(acnumur1.getText().trim(), "") || Objects.equals(amountur.getText().trim(), "")
                || (accnumur2.getText().trim().equals(acnumur1.getText().trim())
                || (Bank.getCurrentUser().findAccount(accnumur2.getText().trim()) == -1 || Bank.getCurrentUser().findAccount(acnumur1.getText().trim()) == -1))) {

            Alert as = new Alert(Alert.AlertType.ERROR);
            as.setTitle("Invalid Data");
            as.setContentText("Please Try again ");
            as.showAndWait();
        } else {
            double amount = parseDouble(amountur.getText());
            opendialog(acnumur1.getText(),accnumur2.getText(), amount ,1 );
        }

    }


    void opendialog(String x1, String x2 , double amount , int mode ) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Transactionusercontrolller.class.getResource("/layout/Confirmpayment.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
//            System.Logger.getLogger(Transactionusercontrolller.class.getName()).log(System.Logger.Level.SEVERE, null, ex);
        }

        ConfirmTransaction confirmTransaction1 = loader.getController();
        confirmTransaction1.senddata(x1, x2, amount ,mode );

        Parent parent = loader.getRoot();
        Stage stage = new Stage();
        stage.getIcons().add(new Image(getClass().getResource("/icons/logicon.png").toString()));
        stage.setTitle("MONEY BIT");
        stage.setScene(new Scene(parent));
        stage.show();
    }
    void opendialog(String x1, String x2 ,String username2, double amount , int mode ) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Transactionusercontrolller.class.getResource("/layout/Confirmpayment.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
//            System.Logger.getLogger(Transactionusercontrolller.class.getName()).log(System.Logger.Level.SEVERE, null, ex);
        }

        ConfirmTransaction confirmTransaction1 = loader.getController();
        confirmTransaction1.senddata(x1, x2, username2 ,amount ,mode );

        Parent parent = loader.getRoot();
        Stage stage = new Stage();
        stage.getIcons().add(new Image(getClass().getResource("/icons/logicon.png").toString()));
        stage.setTitle("MONEY BIT");
        stage.setScene(new Scene(parent));
        stage.show();
    }
}


