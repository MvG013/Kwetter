package web;

import com.mysql.jdbc.StringUtils;
import domain.*;
import service.*;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named
@ViewScoped
public class RegistrationBean implements Serializable {

    @Inject
    private AccountService accountService;
    @Inject
    private UserGroupService userGroupService;

    private UserGroup regularGroup;
    private String emailAddress;
    private String username;
    private String password;

    @PostConstruct
    public void init() {
        this.regularGroup = this.userGroupService.findByGroupName("Regular");
    }

    public void register() throws IOException {
        if (!StringUtils.isNullOrEmpty(emailAddress) && !StringUtils.isNullOrEmpty(username) && !StringUtils.isNullOrEmpty(password)) {
            Account newAccount = new Account(username, emailAddress, password);
            this.accountService.create(newAccount);
            this.regularGroup.addAccount(newAccount);
            this.userGroupService.update(regularGroup);
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        }
        MessageHelper.displayErrorSmallMessage("Fout.", "onjuist ingevulde velden.");
    }


    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
