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
        String firstName="Bukayo";
        assertEquals(firstName,u.getFirstName());
//        String password= "7777";
    }

    @Test
    public void getLastName() {
        String lastName="Saka";
        assertEquals(lastName,u.getLastName());

    }

    @Test
    public void getUsername() {
        String username="saka7";
        assertEquals(username,u.getUsername());
    }

    @Test
    public void setFirstName() {
        User a= new User("Bukayo","Saka","saka7","7777");
        a.setFirstName("123");
        assertEquals("123",a.getFirstName());
    }

    @Test
    public void setLastName() {
        User b= new User("Bukayo","Saka","saka7","7777");
        b.setLastName("123");
        assertEquals("123",b.getLastName());
    }

    @Test
    public void setUsername() {
        User c= new User("Bukayo","Saka","saka7","7777");
        c.setUsername("123");
        assertEquals("123",c.getUsername());

    }
}