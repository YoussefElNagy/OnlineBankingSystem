package com.payup.models;

public class Account {
    private String accountNumber;
    private double balance;
    private String password;
    public Admin admin;
    private double loanAmount;
    //arraylist transactions kolaha 3shan handisplay statements wa5ed balak!!!!!


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getLoanAmount()
    {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
    //public void displayStatement();

}
