package com.payup.models;

public class Admin extends User{

    public Admin(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
    }

    public boolean CheckLoan(double amount)
    {
        return amount<10;
    }

}
