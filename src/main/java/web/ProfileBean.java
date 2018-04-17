package web;

import domain.*;
import service.*;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("profileBean")
@ViewScoped
public class ProfileBean implements Serializable {

    @Inject
    private ProfileService profileService;
    @Inject
    private AccountService accountService;

    private Long id;

    private Account account;

    public void init() {
        if (id != null) {
            this.account = accountService.findById(id);
        }
    }

    public Long getId() {
        return id;
    }
}