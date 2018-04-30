package domain;

import domain.Account;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-23T16:44:13")
@StaticMetamodel(UserGroup.class)
public class UserGroup_ { 

    public static volatile SingularAttribute<UserGroup, String> groupName;
    public static volatile ListAttribute<UserGroup, Account> accounts;

}