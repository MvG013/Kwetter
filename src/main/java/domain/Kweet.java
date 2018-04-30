package domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
        @NamedQuery(name = "Kweet.findAllKweetsByMessage", query = "SELECT kweet FROM Kweet kweet WHERE kweet.text LIKE :message ORDER BY kweet.postTime ASC"),
        @NamedQuery(name = "Kweet.findAllKweetsBySender", query = "SELECT kweet FROM Kweet kweet WHERE kweet.sender.id = :senderId ORDER BY kweet.postTime ASC"),
        @NamedQuery(name = "Kweet.findAllKweetsByHashtagSubject", query = "SELECT kweet FROM Kweet kweet JOIN kweet.hashtags hashtag WHERE hashtag.text = :subject ORDER BY kweet.postTime ASC"),
        @NamedQuery(name = "Kweet.findAllKweetsFromFollowing", query = "SELECT kweet FROM Kweet kweet WHERE kweet.sender = :sender OR kweet.sender IN :following ORDER BY kweet.postTime ASC"),
        @NamedQuery(name = "kweet.findByAccount", query = "SELECT k FROM Kweet k WHERE k.sender = :sender")
})

@XmlRootElement
public class Kweet implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 140)
    private String text;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date postTime;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    private Profile sender;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Heart> hearts;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonBackReference
    private List<Hashtag> hashtags;

    @OneToMany
    private List<Profile> mentions;

    public Kweet(@Size(max = 140) String text, Profile sender) {
        this();
        this.text = text;
        this.sender = sender;
    }

    public Kweet() {
        this.hashtags = new ArrayList<Hashtag>();
        this.mentions = new ArrayList<Profile>();
        this.hearts = new ArrayList<Heart>();
        this.postTime = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Profile getSender() {
        return sender;
    }

    public void setSender(Profile sender) {
        this.sender = sender;
    }

    public List<Heart> getHearts() {
        return hearts;
    }

    public void setHearts(List<Heart> hearts) {
        this.hearts = hearts;
    }

    public List<Profile> getMentions() {
        return mentions;
    }

    public void setMentions(List<Profile> mentions) {
        this.mentions = mentions;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public void addHashtag(Hashtag hashtag) { this.hashtags.add(hashtag); }

    public void addHeart(Heart heart) { this.hearts.add(heart); }

    public void addMention(Profile mention) { this.mentions.add(mention);}



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        final Kweet other = (Kweet) o;
        return Objects.equals(this.sender, other.sender);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public JsonObject toJson() {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        JsonArrayBuilder hashtagArrayBuilder = Json.createArrayBuilder();
        JsonArrayBuilder likesArrayBuilder = Json.createArrayBuilder();

        for (Hashtag hashtag : this.hashtags) {
            hashtagArrayBuilder.add(hashtag.toJson());
        }

        for (Heart heart : this.hearts) {
            likesArrayBuilder.add(heart.toJson());
        }

        return Json.createObjectBuilder()
                .add("id", this.id)
                .add("message", this.text)
                .add("timeOfPosting", dateFormat.format(this.postTime))
                .add("sender", this.sender.toJson())
                .add("hashtags", hashtagArrayBuilder)
                .add("likes", likesArrayBuilder)
                .build();
    }
}
