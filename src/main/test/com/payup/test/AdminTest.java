package com.payup.test;

import com.payup.models.Admin;
import com.payup.models.Bank;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminTest {
  static Admin admin5;
    @BeforeClass
    public static void ClassSetup() throws Exception {
        System.out.println("Start All");
        admin5= new Admin("Youssef","Mostafa","YouMos45","Mostffff64","youssefmost@Moneybit.com","011682393");

        admin5.addNewClient("Youssef","Mostafa","YouMos45","Mostffff64","123",200,"123","saving");
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

//    @Test
//    public void checkLoan() {
//
//    }
    @Test
    public void testGetEmail() {
        Admin admin1 = new Admin("Youssef","Mostafa","YouMos45","Mostffff64","youssefmost@Moneybit.com","011682393");
        assertEquals("youssefmost@Moneybit.com",admin1.getEmail());
    }

    @Test
    public void testSetEmail() {
        Admin admin2 = new Admin("Youssef","Mostafa","YouMos45","Mostffff64","youssefmost@Moneybit.com","011682393");

        admin2.setEmail("12345");
        assertEquals("12345",admin2.getEmail());
    }

    @Test
    public void testGetPhoneNumber() {
        Admin admin3 = new Admin("Youssef","Mostafa","YouMos45","Mostffff64","youssefmost@Moneybit.com","011682393");

        assertEquals("011682393",admin3.getPhoneNumber());
    }

    @Test
    public void testSetPhoneNumber() {
        Admin admin4 = new Admin("Youssef","Mostafa","YouMos45","Mostffff64","youssefmost@Moneybit.com","011682393");

        admin4.setPhoneNumber("1234");
        assertEquals("1234",admin4.getPhoneNumber());
    }


    @Test
    public void testAddNewClient()
    {
        assertEquals(1,Bank.getClients().size());
    }

    @Test
    public void testAddNewAccount()
    {
        admin5.addNewAccount("YouMos45","1234",300,"1234","student");
        assertEquals(2,Bank.getClients().get(0).accountCount);
    }

}
