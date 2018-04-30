package domain;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "heart.findByKweet", query = "SELECT h FROM Heart h WHERE h.kweet = :kweet")
})
public class Heart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Kweet kweet;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date likeTime;



    @OneToOne(cascade = CascadeType.ALL)
    private Profile sender;

    public Heart() {
    }

    public Heart(Kweet kweet, Profile sender) {
        this();
        this.kweet = kweet;
        this.sender = sender;
        this.likeTime = new Date();
    }

    public JsonObject toJson() {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        return Json.createObjectBuilder()
                .add("id", this.id)
                .add("timeOfLiking", dateFormat.format(this.likeTime))
                .add("sender", this.sender.toJson())
                .add("parentKweet", this.kweet.toJson())
                .build();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Kweet getKweet() {
        return kweet;
    }

    public void setKweet(Kweet kweet) {
        this.kweet = kweet;
    }

    public Date getLikeTime() {
        return likeTime;
    }

    public void setLikeTime(Date likeTime) {
        this.likeTime = likeTime;
    }

    public Profile getSender() {
        return sender;
    }

    public void setSender(Profile sender) {
        this.sender = sender;
    }

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
        final Heart other = (Heart) o;
        return Objects.equals(this.kweet, other.kweet);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }
}