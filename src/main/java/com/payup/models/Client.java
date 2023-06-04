package com.payup.models;
import java.util.ArrayList;

public class Client extends User {

    public int accountCount = 0;
    ArrayList<Account> accounts = new ArrayList<Account>();

    public Client(String firstName, String lastName, String username, String password, String accountNumber, double balance, String accPassword, String type) {
        super(firstName, lastName, username, password);
        Account account = new Account(accountNumber, balance, accPassword, type);
        accounts.add(account);
        accountCount++;
    }


    public void addAccount(String accountNumber, double balance, String password, String type) {

        Account a = new Account(accountNumber, balance, password, type);
        accounts.add(a);
        accountCount++;

    }


    public int getAccountCount() {
        return accountCount;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public int findAccount(String accountNumber)
    {
        int s ;
        for(int i =0 ; i<accounts.size();i++)
        {
            if(accountNumber.equals(accounts.get(i).getAccountNumber()))
            {
                s = i;
                return s;
            }
        }

        return -1;
    }

}
