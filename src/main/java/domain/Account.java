package domain;

import util.Hashing;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "account.findByUsername", query = "SELECT a FROM Account a WHERE a.username = :username")
})
public class Account implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    @Size(min = 4, max = 10)
    private String username;

    @NotNull
    private String password;

    @NotNull
    @Column(unique = true)
    @Email
    private String email;

    @NotNull
    @JoinColumn(unique = true)
    @OneToOne(cascade = CascadeType.ALL)
    private Profile profile;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "accounts")
    private List<UserGroup> userGroups;

    public Account(String username,String password, String email) {
        this.username = username;
        this.email = email;
        try {
            this.password = Hashing.hashPassword(password);
        } catch (Exception ex) {
            System.out.println("exception message = " + ex.getMessage());
        }
        this.profile = new Profile();
    }

    public Account() {
        this.userGroups = new ArrayList<>();
    }

//    public JsonObject toJson() {
//        return Json.createObjectBuilder()
//                .add("id", this.id)
//                .add("username", this.username)
//                .add("email", this.email)
//                .add("group", this.group.toString())
//                .add("profile", Json.createObjectBuilder()
//                        .add("firstName", profile.getFirstName())
//                        .add("lastName", profile.getLastName()).build())
//                .build();
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        try {
            this.password = Hashing.hashPassword(password);
        } catch (Exception ex) {
            System.out.println("exception message = " + ex.getMessage());
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Collection<UserGroup> getGroup() {
        return userGroups;
    }

    public void setGroup(List<UserGroup> userGroup) {
        this.userGroups = userGroup;
    }

    public void addGroup(UserGroup userGroup){
        this.userGroups.add(userGroup);
    }

    public void removeGroup(UserGroup userGroup){
        this.userGroups.remove(userGroup);
    }

    public void clearrole() {
        this.userGroups.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(username, account.username) &&
                Objects.equals(email, account.email);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }
}
