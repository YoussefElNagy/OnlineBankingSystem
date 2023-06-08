package com.payup.test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static org.junit.Assert.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccountTest.class, AdminTest.class,ClientTest.class, UserTest.class,BankTest.class
})
public class Runner2 {
}
