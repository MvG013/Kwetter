package domain;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import java.io.Serializable;
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

    @OneToOne(cascade = CascadeType.ALL)
    private Profile sender;

    public Heart() {
    }

    public Heart(Kweet kweet, Profile sender) {
        this();
        this.kweet = kweet;
        this.sender = sender;
    }

//    public JsonObject toJson() {
//        return Json.createObjectBuilder()
//                .add("kweet", Json.createObjectBuilder()
//                        .add("messageBody", this.kweet.getText()).build())
//                .add("profile", Json.createObjectBuilder()
//                        .add("FirstName", this.sender.getFirstName()).build()
//                        .add("Lastname", this.sender.getLastName()).build())
//                .build();
//    }

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