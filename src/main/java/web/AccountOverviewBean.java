package web;

import domain.Account;
import service.AccountService;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;


@Named
@ViewScoped
public class AccountOverviewBean implements Serializable {

    @Inject
    private AccountService accountService;

    private List<Account> accounts;
    private List<Account> filteredAccounts;
    private Account selectedAccount;

    @PostConstruct
    public void init() {
        this.accounts = accountService.findAll();
    }

    public void onRowSelect(SelectEvent event) throws IOException {
        Account selectedAccount = (Account) event.getObject();
        FacesContext.getCurrentInstance().getExternalContext().redirect("details.xhtml?accountId=" + selectedAccount.getId());
    }

    public void remove(Account account) throws IOException {
        if (account != null) {
            this.accountService.delete(account);
            FacesContext.getCurrentInstance().getExternalContext().redirect("accounts.xhtml");
        }
        MessageHelper.displayErrorSmallMessage("Fout.", "Probeer het nog een keer.");
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> getFilteredAccounts() {
        return filteredAccounts;
    }

    public void setFilteredAccounts(List<Account> filteredAccounts) {
        this.filteredAccounts = filteredAccounts;
    }

    public Account getSelectedAccount() {
        return selectedAccount;
    }

    public void setSelectedAccount(Account selectedAccount) {
        this.selectedAccount = selectedAccount;
    }
}
