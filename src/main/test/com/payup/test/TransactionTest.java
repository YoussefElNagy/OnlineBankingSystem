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

    @Test
    public void transfer() {
        String s = T.transfer(e,f,"1177","1240",1000,"7700");
        assertEquals(38000,e.getAccounts().get(e.findAccount("1177")).getBalance(),0.0f);

    }

    @Test
    public void test2Transfer() {
        String s = T.transfer(g,h,"1230","9000",100000000,"6004");
        assertEquals(42300,g.getAccounts().get(g.findAccount("1230")).getBalance(),0.0f);
    }

    @Test
    public void testOnlinePurchase() {
        String s =T.onlinePurchase(j,"4001","1092",1000);
        assertEquals(299000,j.getAccounts().get(j.findAccount("4001")).getBalance(),0.0f);
    }

    @Test
    public void test2OnlinePurchase() {
        String s =T.onlinePurchase(b,"300","1988",100000);
        assertEquals(99999,b.getAccounts().get(b.findAccount("300")).getBalance(),0.0f);
    }
    @Test
    public void test3OnlinePurchase() {
        String s =T.onlinePurchase(j,"4001","1092",-1000);
        assertEquals(300000,j.getAccounts().get(j.findAccount("4001")).getBalance(),0.0f);
    }


    @Test
    public void testPayBill(){
        String s = T.payBill(c,"410", 20000,"9871");
        assertEquals(30505,c.getAccounts().get(c.findAccount("410")).getBalance(),0.0f);
    }

    @Test
    public void test2Paybill(){
        String s = T.payBill(a,"120", 20000000,"9876");
        assertEquals(30000,a.getAccounts().get(a.findAccount("120")).getBalance(),0.0f);
    }
}