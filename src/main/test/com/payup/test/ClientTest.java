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
        double startTime = System.nanoTime();
        c.addAccount("ABCD4321", 500, "44444", "Saving");
        assertEquals(2,c.getAccountCount());
        double endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime));
    }

    @Test
    public void testFindAccount()
    {
        double startTime = System.nanoTime();
        int x = c.findAccount("ABCD1234");
        assertEquals(0,x);
        double endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime));
    }

    @Test
    public void testFindAccount1()
    {
        int x = c.findAccount("Nognog");
        assertEquals(-1,x);
    }


}