package dao.jpa;

import dao.AccountDao;
import dao.GenericDaoJPAImpl;
import dao.JPA;
import domain.Account;

import javax.ejb.Stateless;


@Stateless
@JPA
public class AccountDaoJPA extends GenericDaoJPAImpl<Account> implements AccountDao {

    public AccountDaoJPA() {
    }

    public Account findByUsername(String username) {
        Account userAccount = (Account) this.entityManager.createNamedQuery("Account.findByUsername")
                .setParameter("username", username)
                .getSingleResult();

        if (userAccount != null) {
            return userAccount;
        }

        return null;
    }

    public Account findByCredentials(String username, String password) {
        Account userAccount = (Account) this.entityManager.createNamedQuery("Account.findByCredentials")
                .setParameter("username", username)
                .setParameter("password", password)
                .getSingleResult();

        if (userAccount != null) {
            return userAccount;
        }

        return null;
    }

    @Override
    public Long countAll() {
        return null;
    }
}
