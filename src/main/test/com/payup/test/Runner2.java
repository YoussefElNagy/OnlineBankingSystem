package com.payup.test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static org.junit.Assert.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        com.payup.test.AccountTest.class, com.payup.test.AdminTest.class, com.payup.test.ClientTest.class, com.payup.test.UserTest.class, com.payup.test.BankTest.class
})
public class Runner2 {
}
