package com.payup.models;

public class Admin extends User{
    String email;
    String phoneNumber;

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

//    public boolean checkLoan(double amount)
//    {
//        return amount<100000;
//    }

public void addNewClient(String firstName, String lastName, String username, String password, String accountNumber, double balance, String accPassword, String type)
{
    Client c = new Client(firstName, lastName, username,password,accountNumber,balance,accPassword, type);
    Bank.getClients().add(c);
}

public void addNewAccount(String username ,String accountNumber, double balance, String password, String type)
{
    Client c = Bank.getotheruser(username);
    c.addAccount(accountNumber,balance,password,type);

}

}
