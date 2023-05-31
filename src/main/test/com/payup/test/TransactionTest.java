package com.payup.test;

import com.payup.Transaction;
import com.payup.models.Account;
import com.payup.models.Admin;
import com.payup.models.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionTest {
    Transaction T = new Transaction();
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


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

//    @Test
//    public void testDeposit() {
//        String s = T.deposit(c,"410",1000);
//        assertFalse("Amount should be less than 0",!(s.equals("Amount Deposited Successfully!")));
//
//    }
//
//
//    @Test
//    public void test2Deposit() {
//        String s = T.deposit(d,"7500",-1000);
//        assertFalse("Amount should be less than 0",!(s.equals("Amount Entered must be more than 0")));
//    }
//
//    @Test
//    public void testWithdraw() {
//       String s =  T.withdraw(a,"120",20000);
//       assertTrue("Amount should be less than balance",s.equals("Amount Withdrawn Successfully!"));
//    }
//
//    @Test
//    public void test2Withdraw() {
//        String s =  T.withdraw(b,"300",100000000);
//        assertTrue("Amount should be less than balance",s.equals("Withdraw failed"));
//    }

    @Test
    public void transfer() {
        String s = T.transfer(e,f,"1177","1240",1000,"7700");
        assertTrue("Amount should be less than balance of first account",s.equals("Transaction Completed Successfully!"));

    }

    @Test
    public void test2Transfer() {
        String s = T.transfer(g,h,"1230","9000",100000000,"6004");
        assertTrue("Amount should be less than balance of first account",s.equals("Transaction Failed!"));

    }
    @Test
    public void test3Transfer() {
        String s = T.transfer(a,b,"120","3000",10000,"9876");
        assertTrue("Check Account number of receiver",s.equals("Account number of receiver is not found"));

    }
    @Test
    public void test4Transfer() {
        String s = T.transfer(c,d,"4100","7500",10000000,"9871");
        assertTrue("Check Account number of sender",s.equals("Account number of sender is not found"));

    }


    @Test
    public void testLoan() {
        String s =T.loan(i,"1200",1000,"8890");
        assertFalse("Amount should be less than 100000",!(s.equals("Loan Accepted")));

    }
    @Test
    public void test2Loan() {
        int x =j.findAccount("4001");
        j.getAccounts().get(x).setLoanAmount(1000000);
        String s = T.loan(j,"4001", 400000,"1092");
        assertFalse("Amount should be less than 100000", !(s.equals("Loan Rejected")));
    }



    @Test
    public void testOnlinePurchase() {
        String s =T.onlinePurchase(j,"4001","1092",1000);
        assertFalse("Not enough Balance", !(s.equals("Transaction Successful!")));
    }

    @Test
    public void test2OnlinePurchase() {
        String s =T.onlinePurchase(b,"300","1988",100000);
        assertFalse("Not enough Balance", !(s.equals("Transaction Failed!")));
    }


    @Test
    public void testPayBill(){
        String s = T.payBill(c,"410", 20000,"9871");
        assertTrue("Insufficient Funds",s.equals("Bill Paid Successfully"));

    }
    @Test
    public void test2Paybill(){

        String s = T.payBill(a,"120", 20000000,"9876");
        assertFalse("Insufficient Funds",!(s.equals("Insufficient Funds")));

    }
}