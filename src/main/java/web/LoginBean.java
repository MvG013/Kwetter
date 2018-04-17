package web;

import domain.*;
import service.*;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;

@Named("loginBean")
@RequestScoped
public class LoginBean implements Serializable {

    @Inject
    private AccountService accountService;

    @Inject
    private SessionBean sessionBean;

    private String username;
    private String password;

    public void init() {
    }

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try {
            request.login(this.username, this.password);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        Account loggedInAccount = this.accountService.findByUsername(request.getRemoteUser());
        this.sessionBean.setLoggedInAccount(loggedInAccount);

        boolean isUser = request.isUserInRole("UserRole");

        if (isUser) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("profile.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "";
    }

    //<editor-fold desc="Getters/Setters">
    public AccountService getService() {
        return accountService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}