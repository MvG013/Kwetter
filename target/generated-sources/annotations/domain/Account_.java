package domain;

import domain.Profile;
import domain.UserGroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-23T17:09:50")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile ListAttribute<Account, UserGroup> userGroups;
    public static volatile SingularAttribute<Account, String> password;
    public static volatile SingularAttribute<Account, Profile> profile;
    public static volatile SingularAttribute<Account, Long> id;
    public static volatile SingularAttribute<Account, String> email;
    public static volatile SingularAttribute<Account, String> username;

}