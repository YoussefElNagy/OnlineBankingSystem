package com.payup.test;

import com.payup.models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    User u= new User("Bukayo","Saka","saka7","7777");
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getFirstName() {
        double startTime = System.nanoTime();
        String firstName="Bukayo";
        assertEquals(firstName,u.getFirstName());
        double endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime));
//        String password= "7777";
    }

    @Test
    public void getLastName() {
        double startTime = System.nanoTime();
        String lastName="Saka";
        assertEquals(lastName,u.getLastName());
        double endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime));
    }

    @Test
    public void getUsername() {
        double startTime = System.nanoTime();
        String username="saka7";
        assertEquals(username,u.getUsername());
        double endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime));
    }

    @Test
    public void setFirstName() {
        double startTime = System.nanoTime();
        User a = new User("Bukayo","Saka","saka7","7777");
        a.setFirstName("123");
        assertEquals("123",a.getFirstName());
        double endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime));
    }

    @Test
    public void setLastName() {
        double startTime = System.nanoTime();
        User b= new User("Bukayo","Saka","saka7","7777");
        b.setLastName("123");
        assertEquals("123",b.getLastName());
        double endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime));
    }

    @Test
    public void setUsername() {
        double startTime = System.nanoTime();
        User c= new User("Bukayo","Saka","saka7","7777");
        c.setUsername("123");
        assertEquals("123",c.getUsername());
        double endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime));
    }
}