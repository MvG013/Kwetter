package domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@NamedQueries({
        @NamedQuery(name = "student.findByname", query = "SELECT s FROM Student s WHERE s.name = :name"),
        @NamedQuery(name = "student.count", query = "SELECT COUNT(s) FROM Student s")})

@XmlRootElement
public class User implements Serializable {

    @Id @GeneratedValue
    private Long id;
    private Account account;
    private String photo;
    private String name;
    private String location;
    private String website;
    @Column(length=160)
    private String bio;
    private List<Kweet> kweets;
    private List<User> followers;
    private List<User> following;
    private List<Kweet> mentions;


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
        final User other = (User) obj;
        return Objects.equals(this.name, other.name);
    }

}