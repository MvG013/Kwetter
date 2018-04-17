package web;

import domain.Account;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;


@Named
@SessionScoped
public class SessionBean implements Serializable {

    private Account loggedInAccount;

    public Account getLoggedInAccount() {
        return loggedInAccount;
    }

    public void setLoggedInAccount(Account loggedInAccount) {
        this.loggedInAccount = loggedInAccount;
    }
}
