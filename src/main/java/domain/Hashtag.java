package domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.eclipse.persistence.annotations.CascadeOnDelete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@NamedQueries(
        @NamedQuery(name = "Hashtag.findBySubject", query = "SELECT hashtag FROM Hashtag hashtag WHERE hashtag.text = :subject")
)
public class Hashtag implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String text;

    @OneToMany(cascade = CascadeType.ALL)
    @CascadeOnDelete
    @JsonManagedReference
    private List<Kweet> kweets;

    public Hashtag(String text) {

        this.text = text;
        this.kweets = new ArrayList<Kweet>();
    }

    public Hashtag() {
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("id", this.id)
                .add("subject", this.text)
                .add("popularity", this.kweets.size())
                .build();
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

    public List<Kweet> getKweets() { return kweets; }

    public void addKweet(Kweet kweet) {
        this.kweets.add(kweet);
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
        final Hashtag other = (Hashtag) o;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

}
