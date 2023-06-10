package com.payup.test;

import com.payup.models.Account;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    Account a = new Account("ABCD", 10000, "1234", "Saving");

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getBalance() {
        double startTime = System.nanoTime();
        assertEquals(10000, a.getBalance(), 0.0f);
        double endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime));
    }


    //Testing Set Balance Method
    @Test
    public void setBalance() {
        double startTime = System.nanoTime();
        int newBalance = 2000;
        a.setBalance(newBalance);
        assertEquals(newBalance, a.getBalance(), 0.0f);
        double endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime));
    }

    ////double 7ot 0.0f ka 3rd parameter fel ASSERT
//    @Test
//    public void getLoanAmount() {
//        assertEquals(0, a.getLoanAmount(), 0.0f);
//    }
//
//    @Test
//    public void setLoanAmount() {
//        int newLoanAmount = 5000;
//        a.setLoanAmount(newLoanAmount);
//        assertEquals(newLoanAmount, a.getLoanAmount(),0.0f);
//    }

    @Test
    public void getType() {
        double startTime = System.nanoTime();
        String type = "Saving";
        assertEquals(type, a.getType());
        double endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime));
    }


    @Test
    public void testGetAccountNumber() {
        double startTime = System.nanoTime();
        Account b = new Account("ABCD", 10000, "1234", "Saving");
        assertEquals("ABCD",b.getAccountNumber());
        double endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime));
    }

    @Test
    public void testGetPassword() {
        double startTime = System.nanoTime();
        Account c = new Account("ABCD", 10000, "1234", "Saving");
        assertEquals("1234",c.getPassword());
        double endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime));

    }
}