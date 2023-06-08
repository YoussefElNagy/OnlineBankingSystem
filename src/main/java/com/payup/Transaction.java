package com.payup;

import com.payup.models.Account;
import com.payup.models.Admin;
import com.payup.models.Client;

public class Transaction {

//    public String deposit(Client c, String accountNumber, double amount) {
//        int i=c.findAccount(accountNumber);
//        Account a=c.getAccounts().get(i);
//        if(amount>0) {
//            a.setBalance(a.getBalance() + amount);
//            return "Amount Deposited Successfully!";
//        }
//        else return "Amount Entered must be more than 0";
//    }
//
//    public String withdraw(Client c ,String accountNumber, double amount) {
//        int i=c.findAccount(accountNumber);
//        Account a=c.getAccounts().get(i);
//        if(a.getBalance()>=amount) {
//            a.setBalance(a.getBalance() - amount);
//            return "Amount Withdrawn Successfully!";
//        }
//        return "Withdraw failed";
//    }

    public String transfer (Client c1, Client c2,String accountNumber1, String accountNumber2,double amount, String password){
        int i=c1.findAccount(accountNumber1);
        if(i==-1)
        {return "Account number of sender is not found";}
        Account a=c1.getAccounts().get(i);
        if(a.getAccountNumber().equals(accountNumber1) && a.getPassword().equals(password)) {

            int j = c2.findAccount(accountNumber2);
            if (j == -1) {
                return "Account number of receiver is not found";
            }
            Account b = c2.getAccounts().get(j);
            if(amount<=0)
                return "Transaction Failed!";


            if (a.getBalance() >= amount) {
                a.setBalance(a.getBalance() - amount);
                b.setBalance(b.getBalance() + amount);
                c1.getStatments().add("Transferred money to account number " + accountNumber2 + " with amount " + amount + "$.");
                c2.getStatments().add("Received " + amount + "$ from account number " + accountNumber1+ ".");
                return "Transaction Completed Successfully!";
            }else return "Insufficient Funds";
            }
            return "Transaction Failed!";
        }


    public String onlinePurchase(Client c, String accountNumber, String password, double price){
        int i=c.findAccount(accountNumber);
        if(i==-1)
        {return "Account number is not found";}
        Account a=c.getAccounts().get(i);
        if(a.getAccountNumber().equals(accountNumber) && a.getPassword().equals(password)) {

            if(a.getAccountNumber().equals(accountNumber) && a.getPassword().equals(password)) {
           if (a.getBalance() >= price) {
               a.setBalance(a.getBalance() - price);
               c.getStatments().add("Made online purchase for " + price + "$.");
               return "Transaction Completed Successfully!";
           }
           else return "Transaction Failed!";
       }
        }
            return "Transaction Failed!";
    }


    public String payBill(Client c, String accountNumber,double amount , String password) {
        int i=c.findAccount(accountNumber);
        if(i==-1)
        {
            return "Account number is not found";
        }

        Account a=c.getAccounts().get(i);
        if(a.getAccountNumber().equals(accountNumber) && a.getPassword().equals(password)) {

             if (a.getBalance() >= amount) {
                a.setBalance(a.getBalance() - amount);
                c.getStatments().add("Paid bill with amount " + amount);
                return "Bill Paid Successfully";
            }else {

                 return "Insufficient Funds";
             }
        }else {
            return "Transaction Failed!";}



    }

//    public String loan(Client c, String accountNumber, double amount,String password) {
//        int i = c.findAccount(accountNumber);
//        if (i == -1) {
//            return "Account number is not found";
//        }
//        Account a = c.getAccounts().get(i);
//        if(a.getAccountNumber().equals(accountNumber) && a.getPassword().equals(password)) {
//
//            if (a.admin.checkLoan(a.getLoanAmount())) {
//            a.setLoanAmount(a.getLoanAmount() + amount);
//            return "Loan Accepted";}
//            else {
//                return "Loan Rejected";
//            }
//        }
//        else {
//            return "Invalid account/password!";
//        }
//    }
}
