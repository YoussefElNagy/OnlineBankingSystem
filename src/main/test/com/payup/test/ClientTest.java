package com.payup.test;

import com.payup.models.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {


    //    public Client(String firstName, String lastName,
    //    String username, String password, String accountNumber,
    //    double balance, String accPassword,  String type)

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    Client c= new Client("Nognog","Nog","Nognog6","4444", "ABCD1234", 100, "44444", "Personal");

    @Test
    public void addAccount(){
        c.addAccount("ABCD4321", 500, "44444", "Saving");
        assertEquals(2,c.getAccountCount());
    }
}