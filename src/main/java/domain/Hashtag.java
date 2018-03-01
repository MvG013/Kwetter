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
public class Hashtag implements Serializable{

    @Id @GeneratedValue
    private Long id;
    private String subject;
}
