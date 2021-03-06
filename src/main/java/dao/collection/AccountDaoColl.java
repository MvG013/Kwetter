package dao.collection;

import dao.AccountDao;
import domain.Account;
import domain.Hashtag;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Stateless
@Default

public class AccountDaoColl implements AccountDao {

    CopyOnWriteArrayList<Account> accounts = new CopyOnWriteArrayList<Account>();

    public Account create(Account account) {
        accounts.add(account);
        return account;
    }

    public Account update(Account account) {
        return null;
    }


    public void delete(Account account) {
        for (Account foundAccount : accounts) {
            if (foundAccount.equals(account)) {
                accounts.remove(account);
            }
        }
    }
    public void deleteById(Long id) {
        Account account = findById(id);
        if (account != null) {
            accounts.remove(account);
        }
    }

    public Account findById(Long id) {
        for (Account account : accounts) {
            if (account.getId().equals(id)) {
                return account;
            }
        }
        return null;
    }

    public List<Account> findAll() {
        return accounts;
    }

    @Override
    public Long countAll() {
        return null;
    }

    @Override
    public Account findByUsername(String username) {
        return null;
    }

    @Override
    public Account findByCredentials(String username, String password) {
        return null;
    }
}