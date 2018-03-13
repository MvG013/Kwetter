package service;

import domain.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;


@Singleton
@Startup
public class StartUp {

    @Inject
    private AccountService accountService;

    public StartUp() {
    }

    @PostConstruct
    private void init(){

        Account account = new Account();
        account.setUsername("Jens");
        account.setEmail("jensbeek@hotmail.com");
        account.setPassword("joost12");
        account.setRole(Role.Moderator);
        account.setProfile(new Profile());
        accountService.create(account);

        Account account2 = new Account();
        account2.setUsername("Joost");
        account2.setEmail("Joostenbrood@hotmail.com");
        account2.setPassword("Joost12");
        account2.setRole(Role.Administrator);
        account2.setProfile(new Profile());
        accountService.create(account2);

        Account account3 = new Account();
        account3.setUsername("Henk");
        account3.setEmail("Henkjonge@hotmail.com");
        account3.setPassword("Henk12");
        account3.setRole(Role.User);
        account3.setProfile(new Profile());
        accountService.create(account3);
    }
}
