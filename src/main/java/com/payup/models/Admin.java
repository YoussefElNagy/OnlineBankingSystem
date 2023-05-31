package com.payup.models;

public class Admin extends User{

    public Admin(String firstName, String lastName, String username, String password, String email, String phoneNumber) {
        super(firstName, lastName, username, password);
        this.email=email;
        this.phoneNumber =phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean checkLoan(double amount)
    {
        return amount<100000;
    }

}
