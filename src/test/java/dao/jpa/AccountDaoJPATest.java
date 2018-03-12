package dao.jpa;

import domain.Account;
import domain.Role;
import org.junit.Before;
import org.junit.Test;
import util.DatabaseCleaner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class AccountDaoJPATest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("AccountTestPU");
    private EntityManager em;
    private EntityTransaction tx;
    private AccountDaoJPA accountDaoJPA;

    private Account account = null;

    public AccountDaoJPATest() {
    }

    @Before
    public void setUp() {
        try {
            new DatabaseCleaner(emf.createEntityManager()).clean();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDaoJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
        em = emf.createEntityManager();
        tx = em.getTransaction();

        this.accountDaoJPA = new AccountDaoJPA();
        accountDaoJPA.setEntityManager(em);
        account = new Account("RensTest", "RensTest", "RensTest@hotmail.com" , Role.User);
    }

    @Test
    public void testCreate() {
        int expResult = 1;

        tx.begin();
        this.accountDaoJPA.create(account);
        tx.commit();
        tx.begin();
        int amount = accountDaoJPA.findAll().size();
        tx.commit();
        assertThat(amount, is(expResult));
    }
}