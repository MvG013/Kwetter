package service;

import com.mysql.jdbc.StringUtils;
import dao.AccountDao;
import dao.JPA;
import domain.Account;
import util.Hashing;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class AccountService {

    @Inject
    @JPA
    private AccountDao accountDao;

    public AccountService() {
    }

    public Account create(Account account) {
        return this.accountDao.create(account);
    }

    public Account update(Account account) {
        return this.accountDao.update(account);
    }

    public void delete(Account account) {
        this.accountDao.delete(account);
    }

    public void delete(Long id) {
        this.accountDao.deleteById(id);
    }

    public Account findById(Long id) {
        return this.accountDao.findById(id);
    }

    public List<Account> findAll() {
        return this.accountDao.findAll();
    }

    public Account findByUsername(String username) {
        if (!StringUtils.isNullOrEmpty(username)) {
            return this.accountDao.findByUsername(username);
        }
        return null;
    }

}