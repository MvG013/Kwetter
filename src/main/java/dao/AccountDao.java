package dao;

import domain.Account;

public interface AccountDao extends GenericDao<Account>{

    Account findByUsername(String username);

    Account findByCredentials(String username, String password);
}
