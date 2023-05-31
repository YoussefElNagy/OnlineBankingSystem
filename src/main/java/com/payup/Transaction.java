package com.payup;

import com.payup.models.Account;
import com.payup.models.Admin;

public class Transaction {

    String deposit(Account a, double amount) {
        a.setBalance(a.getBalance()+amount);
        return "Amount Deposited Successfully!";
    }

    String withdraw(Account a, double amount) {
        if(a.getBalance()>=amount) {
            a.setBalance(a.getBalance() - amount);
            return "Amount Withdrawn Successfully!";
        }
        return "Withdraw failed";
    }

    String transfer (Account a, Account b, double amount){
        if(a.getBalance()>=amount){
            a.setBalance(a.getBalance()-amount);
            b.setBalance(b.getBalance()+amount);
            return "Transaction Completed Successfully!";
        }
        return "Transaction Failed!";

    }

    //String onlinePurchase();

    String loan(Account a , double amount)
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
