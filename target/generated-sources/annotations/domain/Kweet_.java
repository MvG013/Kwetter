package domain;

import domain.Hashtag;
import domain.Heart;
import domain.Profile;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-23T16:44:13")
@StaticMetamodel(Kweet.class)
public class Kweet_ { 

    public static volatile SingularAttribute<Kweet, Date> postTime;
    public static volatile ListAttribute<Kweet, Hashtag> hashtags;
    public static volatile SingularAttribute<Kweet, Profile> sender;
    public static volatile ListAttribute<Kweet, Profile> mentions;
    public static volatile ListAttribute<Kweet, Heart> hearts;
    public static volatile SingularAttribute<Kweet, Long> id;
    public static volatile SingularAttribute<Kweet, String> text;

}