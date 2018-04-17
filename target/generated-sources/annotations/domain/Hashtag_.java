package domain;

import domain.Kweet;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-05T16:23:37")
@StaticMetamodel(Hashtag.class)
public class Hashtag_ { 

    public static volatile ListAttribute<Hashtag, Kweet> kweets;
    public static volatile SingularAttribute<Hashtag, Long> id;
    public static volatile SingularAttribute<Hashtag, String> text;

}