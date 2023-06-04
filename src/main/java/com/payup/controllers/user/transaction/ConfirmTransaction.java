package com.payup.controllers.user.transaction;



import com.payup.Transaction;
import com.payup.models.Account;
import com.payup.models.Bank;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ConfirmTransaction {
    private String accnum1 ;
    private String accnum2 ;
    private String other_usr;
    private double amount ;
    private int mode ;


    ArrayList<Account> accounts = Bank.getCurrentUser().getAccounts()  ;

    @FXML
    private TextField idfield;

    @FXML
    void onConfirmclicked(MouseEvent event) {

                int x = Bank.getCurrentUser().findAccount(accnum1);
                System.out.println(Bank.getCurrentUser().getAccounts().get(x).getBalance());
                System.out.println(Bank.getCurrentUser().getAccounts().get(x).getPassword());
                if(idfield.getText().trim().equals(Bank.getCurrentUser().getAccounts().get(x).getPassword())){
                    Transaction newtranscaction = new Transaction();
                    switch (mode){
                        /*
                         * 1 urself
                         * 2 pay bills
                         * 3  other
                         * 4 online purschase
                         * */

                        case 1 :
                            newtranscaction.transfer(Bank.getCurrentUser(),Bank.getCurrentUser(),accnum1,accnum2,amount,idfield.getText().trim());
                            System.out.println(Bank.getCurrentUser().getAccounts().get(x).getBalance());
                            break;
                        case 2 :
                            newtranscaction.payBill(Bank.getCurrentUser(),accnum1,amount,idfield.getText().trim());
                            break;
                        case 3 :
                            break;
                        case 4 :
                            newtranscaction.transfer(Bank.getCurrentUser(),Bank.getotheruser(other_usr),accnum1,accnum2,amount,idfield.getText().trim());
                            System.out.println(Bank.getotheruser(other_usr).getAccounts().get( Bank.getotheruser(other_usr).findAccount(accnum2)).getBalance());
                            break;


                    }

                    Node source = (Node)  event.getSource();
                    Stage stage  = (Stage) source.getScene().getWindow();
                    stage.close();

        }



        }




    public void senddata(String x1, String x2, double amount , int mode ) {
        setAccnum1(x1);
        setAccnum2(x2);
        setAmount(amount);
        setMode(mode);
    }
    public void senddata(String x1, String x2,String username, double amount , int mode ) {
        setAccnum1(x1);
        setAccnum2(x2);
        setAmount(amount);
        setMode(mode);
        setOther_usr(username);


    }

    public String getAccnum1() {
        return accnum1;
    }

    public void setAccnum1(String accnum1) {
        this.accnum1 = accnum1;
    }

    public String getAccnum2() {
        return accnum2;
    }

    public void setAccnum2(String accnum2) {
        this.accnum2 = accnum2;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TextField getIdfield() {
        return idfield;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getOther_usr() {
        return other_usr;
    }

    public void setOther_usr(String other_usr) {
        this.other_usr = other_usr;
    }
}
