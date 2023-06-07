package com.payup.test;

import com.payup.models.Admin;
import com.payup.models.Bank;
import com.payup.models.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class BankTest {
    static Bank a;
    @BeforeClass
    public static void ClassSetup() throws Exception {
        System.out.println("Start All");
         a = new Bank();
        Client b = new Client("Seif","Seif","$$$$$","5672","300",99999,"1988","Personal");
        a.getClients().add(b);

    }


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


@Test
    public void check_user_cred(){
        assertTrue("Wrong password or username",a.check_user_cred("$$$$$","5672"));

    }

    @Test
    public void check_user_cred1(){
        assertFalse("Correct password or username",a.check_user_cred("$$$$$","1999"));

    }
    @Test
    public void check_user_cred2(){
        assertFalse("Correct password or username",a.check_user_cred("301","5672"));

    }

    @Test
    public void check_user_cred3(){
        assertFalse("Correct password or username",a.check_user_cred("301","1999"));

    }




}