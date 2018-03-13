package domain;

import domain.Kweet;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-13T13:10:15")
@StaticMetamodel(Heart.class)
public class Heart_ { 

    public static volatile SingularAttribute<Heart, Kweet> kweet;
    public static volatile SingularAttribute<Heart, Long> id;
    public static volatile SingularAttribute<Heart, Date> heartDate;

}