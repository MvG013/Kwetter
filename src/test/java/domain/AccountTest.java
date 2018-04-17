package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountTest {

    private Account account = null;
    private Account account2 = null;
    private Profile profile = null;
    private UserGroup userGroup = null;

    @Before
    public void setUp() {
        account = new Account();
        account2 = new Account("RensTest",  "RensTest", "RensTest@hotmail.com");
        profile = new Profile();
    }

    @Test
    public void testGetAndSetId() {
        Long id = 12345L;
        account.setId(id);
        Long expResult = id;
        Long result = account.getId();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAndSetUserName() {
        String userName = "RensTest";
        account.setUsername(userName);
        String expResult = userName;
        String result = account.getUsername();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAndSetEmailAddress() {
        String email = "RensTest@hotmail.com";
        account.setEmail(email);
        String expResult = email;
        String result = account.getEmail();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAndSetPassword() {
        String password = "RensTest";
        account.setPassword(password);
        String expResult = password;
        String result = account.getPassword();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAndSetProfile() {
        account.setProfile(profile);
        Profile expResult = profile;
        Profile result = account.getProfile();
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals() {
        Account test1 = new Account("JensTest", "test", "JensTest@hotmail.nl");
        String userName = "RensTest";
        String email = "RensTest@hotmail.com";
        String password = "RensTest";
        account.setUsername(userName);
        account.setEmail(email);
        account.setPassword(password);

        assertFalse(account.equals(test1));
        assertTrue(account.equals(account2));
        assertTrue(account.equals(account));
    }

    @Test
    public void testHashCode() {
        Long id = 123L;
        account.setId(id);
        account2.setId(id);
        assertEquals(account.hashCode(), account2.hashCode());
    }

}
