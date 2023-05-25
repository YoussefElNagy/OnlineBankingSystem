package com.example.onlinebankingsystem;

public class Client extends User{

    protected Account account= new Account();

    public Client(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
    }


}
