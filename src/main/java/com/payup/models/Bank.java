package com.payup.models;

import com.payup.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Bank  {
    //arraylist users
    //arraylist admins
    //arraylist accounts


    // Users
    private static ArrayList<User> users = new ArrayList<>();
    private static  Client currentUser  ;


    private static ArrayList<Client> clients = new ArrayList<>();
    Client a = new Client("Nagy","Ebn ElNagy","N@gy23","Nognog69","120",30000,"9876","Saving");
    Client b = new Client("Seif","Seif","$$$$$","5672","300",99999,"1988","Personal");
    Client c = new Client("Nognoga","Nognogti","Nognogto","9876","410",50505,"9871","Saving");
    Client d = new Client("Lil","Gaded","LilGaded","9876","7500",696969,"8820","Business");
    Client e = new Client("Boody","Essam","Boody3essam","9876","1177",39000,"7700","Saving");
    Client f = new Client("Juliana","Emad","JUUUUUUUU","9876","1240",56000,"8766","Personal");
    Client g = new Client("Moisis","George","MisoGeorge","9876","1230",42300,"6004","Personal");
    Client h = new Client("Joe","Mohamed","JoeJoeJoe","9876","9000",69000,"9120","Personal");
    Client i = new Client("Saeed","Elhawa","HappyTheAir","9876","1200",48512,"8890","Business");
    Client j = new Client("Snoop","Nogg","SnoopNogg69","9876","4001",300000,"1092","Customer");

    public void setdatabase_Clients(){
        g.addAccount("723",723.00,"723","Savings");
        g.addAccount("674",82323.00,"passs123d","Personal");
        Collections.addAll(clients, a,b,c,d,e,f,g,h,i,j);

        // Test
        for (int k = 0; k <clients.size() ; k++) {
            System.out.println(clients.get(k).firstName);
        }
    }


//    public void setdatabase_accounts(){
//        Collections.addAll(clients, a,b,c,d,e,f,g,h,i,j);
//        // Test
//        for (int k = 0; k <clients.size() ; k++) {
//            System.out.println(clients.get(k).firstName);
//        }
//    }




    //    public User(String firstName, String lastName, String username, String password) {



    //admin
    private ArrayList<Admin> admins = new ArrayList<>();


    //accounts
    private ArrayList<Account> accounts = new ArrayList<>();


    //transaction
    private  ArrayList<Transaction> transactionArrayList = new ArrayList<>() ;


    // functions
    public boolean check_user_cred(String username, String password){
        for (int i = 0 ; i <clients.size() ; ++i){
            if(Objects.equals(clients.get(i).getUsername(), username) && Objects.equals(clients.get(i).getPassword(), password)) {
                setcurrentUser(username);
                return true ;
            }
        }
        return false ;
    }

    public static ArrayList<Client> getClients() {
        return clients;
    }

    private void setcurrentUser(String username) {
        for (int i = 0 ; i <clients.size() ; ++i){
            if(Objects.equals(clients.get(i).getUsername(), username)) {
                currentUser = clients.get(i);
            }
        }
    }

    public  static Client getotheruser(String username){
        for (int i = 0 ; i <clients.size() ; ++i){
            if(Objects.equals(clients.get(i).getUsername(), username)) {
                return clients.get(i);
            }
        }
        return null ;
    }


    public static Client getCurrentUser() {
        return currentUser;
    }

}
