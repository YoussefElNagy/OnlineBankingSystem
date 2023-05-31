package com.payup;

import com.payup.models.Account;
import com.payup.models.Admin;
import com.payup.models.Client;

public class Transaction {

    public String deposit(Client c, String accountNumber, double amount) {
        int i=c.findAccount(accountNumber);
        Account a=c.getAccounts().get(i);
        if(amount>0) {
            a.setBalance(a.getBalance() + amount);
            return "Amount Deposited Successfully!";
        }
        else return "Amount Entered must be more than 0";
    }

    public String withdraw(Client c ,String accountNumber, double amount) {
        int i=c.findAccount(accountNumber);
        Account a=c.getAccounts().get(i);
        if(a.getBalance()>=amount) {
            a.setBalance(a.getBalance() - amount);
            return "Amount Withdrawn Successfully!";
        }
        return "Withdraw failed";
    }

    public String transfer (Client c1, Client c2,String accountNumber1, String accountNumber2,double amount){
        int i=c1.findAccount(accountNumber1);
        Account a=c1.getAccounts().get(i);

        int j=c2.findAccount(accountNumber2);
        Account b=c2.getAccounts().get(j);

        if(a.getBalance()>=amount){
            a.setBalance(a.getBalance()-amount);
            b.setBalance(b.getBalance()+amount);
            return "Transaction Completed Successfully!";
        }
        return "Transaction Failed!";

    }

    public String onlinePurchase(Client c, String accountNumber, String password, double price){
        int i=c.findAccount(accountNumber);
        Account a=c.getAccounts().get(i);

        if(a.getAccountNumber().equals(accountNumber) && a.getPassword().equals(password)) {
           if (a.getBalance() >= price) {
               a.setBalance(a.getBalance() - price);
               return "Transaction Successful!";
           }
           else return "Transaction Failed!";
       }
            return "Transaction Failed!";
    }


    public String payBill(Client c, String accountNumber,double amount) {
        int i=c.findAccount(accountNumber);
        Account a=c.getAccounts().get(i);

        if(a.getBalance()>=amount) {
            a.setBalance(a.getBalance()-amount);
            return "Bill Paid Successfully";
        }

         return "Insufficient Funds";


    }

    public String loan(Client c, String accountNumber, double amount) {
        int i=c.findAccount(accountNumber);
        Account a=c.getAccounts().get(i);

        if(a.admin.checkLoan(a.getLoanAmount()))
        {
            a.setLoanAmount(a.getLoanAmount()+amount);
            return "Loan Accepted";
        }

        else return "Loan Rejected";


    }
}
