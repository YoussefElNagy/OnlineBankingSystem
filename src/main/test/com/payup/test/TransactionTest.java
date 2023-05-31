package com.payup.test;

import com.payup.Transaction;
import com.payup.models.Account;
import com.payup.models.Admin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionTest {
    Transaction T = new Transaction();
    Account a = new Account("1234",30000,"12345","saving");
    Account b = new Account("1234",30000,"12345","saving");
    Account c = new Account("1234",30000,"12345","saving");
    Account d = new Account("1234",30000,"12345","saving");
    Account e = new Account("1234",30000,"12345","saving");
    Account f = new Account("1234",30000,"12345","saving");
    Account g = new Account("1234",30000,"12345","saving");
    Account h = new Account("1234",30000,"12345","saving");
    Account i = new Account("1234",30000,"12345","saving");
    Account j = new Account("1234",30000,"12345","saving");

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deposit() {
        String s = T.deposit(c,1000);
        assertFalse("Amount should be less than 0",!(s.equals("Amount Deposited Successfully!")));

    }


    @Test
    public void test2Deposit() {
        String s = T.deposit(d,-1000);
        assertFalse("Amount should be less than 0",!(s.equals("Amount Entered must be more than 0")));
    }

    @Test
    public void withdraw() {
       String s =  T.withdraw(a,20000);
       assertTrue("Amount should be less than balance",s.equals("Amount Withdrawn Successfully!"));
    }

    @Test
    public void test2withdraw() {
        String s =  T.withdraw(b,100000000);
        assertTrue("Amount should be less than balance",s.equals("Withdraw failed"));
    }

    @Test
    public void transfer() {
        String s = T.transfer(e,f,1000);
        assertTrue("Amount should be less than balance of first account",s.equals("Transaction Completed Successfully!"));

    }

    @Test
    public void test2Transfer() {
        String s = T.transfer(g,h,10000000);
        assertTrue("Amount should be less than balance of first account",s.equals("Transaction Failed!"));

    }

    @Test
    public void loan() {
        String s =T.loan(i,1000);
        assertFalse("Amount should be less than 100000",!(s.equals("Loan accepted")));

    }
    @Test
    public void test2Loan() {
        j.setLoanAmount(100000);
        String s = T.loan(j, 400000);
        assertFalse("Amount should be less than 100000", !(s.equals("Loan rejected")));
    }

}