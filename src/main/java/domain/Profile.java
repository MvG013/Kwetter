package domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "profile.findByUsername", query = "SELECT p FROM Profile p WHERE p.account.username = :username")
})
public class Profile implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photo;
    private String firstName;
    private String lastName;
    private String location;
    private String website;
    private String birthDay;

    @Column(length=160)
    private String bio;


    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sender", orphanRemoval = true)
    private List<Kweet> kweets;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Kweet> mentionKweets;

    @ManyToMany(cascade = CascadeType.PERSIST , mappedBy = "following")
    private List<Profile> followers;

    @ManyToMany
    private List<Profile> following;

    public Profile(String firstName, String lastName) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Profile(String firstName, String lastName, Account account) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
    }

    public Profile(String firstName, String lastName, String photo, String location, String bio, Account account, String birthday) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
        this.location = location;
        this.bio = bio;
        this.account = account;
        this.birthDay = birthday;
    }

    public Profile() {
        this.followers = new ArrayList<Profile>();
        this.following = new ArrayList<Profile>();
        this.kweets = new LinkedList<Kweet>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Kweet> getKweets() {
        return kweets;
    }

    public void setKweets(List<Kweet> kweets) {
        this.kweets = kweets;
    }

    public List<Profile> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Profile> followers) {
        this.followers = followers;
    }

    public List<Profile> getFollowing() {
        return following;
    }

    public void setFollowing(List<Profile> following) {
        this.following = following;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public List<Kweet> getMentionKweets() {
        return mentionKweets;
    }

    public void setMentionKweets(List<Kweet> mentionKweets) {
        this.mentionKweets = mentionKweets;
    }

    public void addKweet(Kweet kweet) {
        this.kweets.add(kweet);
    }

    public void addFollowing(Profile following) {
        this.following.add(following);
    }

    public void addFollower(Profile follower) {
        this.followers.add(follower);
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profile other = (Profile) obj;
        return Objects.equals(this.firstName, other.firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public JsonObject toJson() {

        return Json.createObjectBuilder()
                .add("id", this.id)
                .add("username", this.account.getUsername())
                .add("email", this.account.getEmail())
                .add("location", this.location)
                .add("firstName", this.firstName)
                .add("lastName", this.lastName)
                .add("biography", this.bio)
                .add("dateOfBirth", this.birthDay)
                .add("avatarUrl", this.photo)
                .add("amountFollowers", this.followers.size())
                .add("amountFollowing", this.following.size())
                .build();
    }
}