package com.payup;

import com.payup.models.Account;
import com.payup.models.Admin;

public class Transaction {

    public String deposit(Account a, double amount) {
        if(amount>0) {
            a.setBalance(a.getBalance() + amount);
            return "Amount Deposited Successfully!";
        }
        else
        {return "Amount Entered must be more than 0";}
    }

    public String withdraw(Account a, double amount) {
        if(a.getBalance()>=amount) {
            a.setBalance(a.getBalance() - amount);
            return "Amount Withdrawn Successfully!";
        }
        return "Withdraw failed";
    }

    public String transfer (Account a, Account b, double amount){
        if(a.getBalance()>=amount){
            a.setBalance(a.getBalance()-amount);
            b.setBalance(b.getBalance()+amount);
            return "Transaction Completed Successfully!";
        }
        return "Transaction Failed!";

    }

    //String onlinePurchase();

    public String loan(Account a , double amount)
    {
        if(a.admin.checkLoan(a.getLoanAmount()))
        {
            a.setLoanAmount(a.getLoanAmount()+amount);
            return "Loan accepted";
        }
        else
        {
            return "Loan rejected";
        }

    }
}
