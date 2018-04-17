package service;

import domain.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.Hashing;

import static org.junit.Assert.assertEquals;

public class HashServiceTest {


    Account account = null;

    @Before
    public void setUp() {
        account = new Account("testUsername", "testPassword", "test@testMail.com");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hashTest(){
        String password = "test";
        String expResult = "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08";
        String result = Hashing.hashPassword(password);
        assertEquals(expResult, result);
    }


}
