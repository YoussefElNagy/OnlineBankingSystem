package com.payup.controllers.user.transaction;



import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ConfirmTransaction {
    private String accnum1 ;
    private String accnum2 ;
    private double amount ;

    @FXML
    private TextField idfield;

    @FXML
    void onConfirmclicked(MouseEvent event) {
        //if


    }

    public void senddata(String x1, String x2, double amount) {
        setAccnum1(x1);
        setAccnum2(x2);
        setAmount(amount);
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









}
