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
        return getEntityManager().createNamedQuery("account.findByUsername", Account.class)
                .setParameter("username", username)
                .getSingleResult();
    }
}
