package dao.collection;

import domain.Account;
import domain.Role;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AccountDaoCollTest {

    private AccountDaoColl accountDaoColl;
    private Account account = null;
    private Account account2 = null;

    public AccountDaoCollTest() {
    }

    @Before
    public void setUp() {
        this.accountDaoColl = new AccountDaoColl();
        this.account = new Account("jensTest",  "jensTest", "jensTest@hotmail.com",Role.User);
        this.account2 = new Account("JoostTest",  "jensTest", "JoostTest@hotmail.com",Role.Administrator);
    }

    @Test
    public void testCreate() {
        this.accountDaoColl.create(account);
        assertEquals(1, accountDaoColl.accounts.size());
    }
}