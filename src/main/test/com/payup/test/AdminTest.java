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
        double startTime = System.nanoTime();
        Admin admin1 = new Admin("Youssef","Mostafa","YouMos45","Mostffff64","youssefmost@Moneybit.com","011682393");
        assertEquals("youssefmost@Moneybit.com",admin1.getEmail());
        double endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime));
    }

    @Test
    public void testSetEmail() {
        double startTime = System.nanoTime();
        Admin admin2 = new Admin("Youssef","Mostafa","YouMos45","Mostffff64","youssefmost@Moneybit.com","011682393");

        admin2.setEmail("12345");
        assertEquals("12345",admin2.getEmail());
        double endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime));
    }

    @Test
    public void testGetPhoneNumber() {
        double startTime = System.nanoTime();
        Admin admin3 = new Admin("Youssef","Mostafa","YouMos45","Mostffff64","youssefmost@Moneybit.com","011682393");

        assertEquals("011682393",admin3.getPhoneNumber());
        double endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime));
    }

    @Test
    public void testSetPhoneNumber() {
        double startTime = System.nanoTime();
        Admin admin4 = new Admin("Youssef","Mostafa","YouMos45","Mostffff64","youssefmost@Moneybit.com","011682393");

        admin4.setPhoneNumber("1234");
        assertEquals("1234",admin4.getPhoneNumber());
        double endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime));
    }


    @Test
    public void testAddNewClient()
    {
        double startTime = System.nanoTime();
        assertEquals(1,Bank.getClients().size());
        double endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime));
    }

    @Test
    public void testAddNewAccount()
    {
        double startTime = System.nanoTime();
        admin5.addNewAccount("YouMos45","1234",300,"1234","student");
        assertEquals(2,Bank.getClients().get(0).accountCount);
        double endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime));
    }

}
