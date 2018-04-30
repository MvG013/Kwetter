package web;

import domain.Account;
import org.omnifaces.util.Faces;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import java.io.Serializable;

import static org.omnifaces.util.Faces.invalidateSession;
import static org.omnifaces.util.Faces.redirect;


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

    public void logout() throws ServletException {
        this.loggedInAccount = null;

        Faces.logout();
        invalidateSession();
        redirect("login.xhtml?faces-redirect=true");
    }
}
