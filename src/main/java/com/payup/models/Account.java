package com.payup.models;
public class Account {
    private String accountNumber;
    private double balance;
    private String password;
    public Admin admin;
    private double loanAmount;
    //arraylist transactions kolaha 3shan handisplay statements wa5ed balak!!!!!
    private String type; //saving personal business masalan

    public Account() {}

    public Account(String accountNumber, double balance, String password,  String type) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.password = password;
        this.loanAmount = 0;
        this.type = type;
        this.admin=new Admin("Youssef","Mostafa","YouMos45","Mostffff64","youssefmost@Moneybit.com","011682393");
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance>=0) {
            this.balance = balance;
        }
    }
    public double getLoanAmount()
    {
        return loanAmount;
    }

    public String getType() {
        return type;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
    //public void displayStatement();


    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }
}
