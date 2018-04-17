package domain;

import domain.Kweet;
import domain.Profile;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-05T16:23:37")
@StaticMetamodel(Heart.class)
public class Heart_ { 

    public static volatile SingularAttribute<Heart, Kweet> kweet;
    public static volatile SingularAttribute<Heart, Profile> sender;
    public static volatile SingularAttribute<Heart, Long> id;

}