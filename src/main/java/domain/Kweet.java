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
public class Kweet implements Serializable {

    @Id @GeneratedValue
    private Long id;
    private Long senderID;
    @Column(length=140)
    private String text;
    private List<User> hartjes;
    private List<User> mentions;
    private List<Hashtag> hashtags;

}
