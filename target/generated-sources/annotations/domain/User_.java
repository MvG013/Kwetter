package domain;

import domain.Account;
import domain.Kweet;
import domain.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-09T11:41:15")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> website;
    public static volatile ListAttribute<User, User> followers;
    public static volatile ListAttribute<User, User> following;
    public static volatile ListAttribute<User, Kweet> mentions;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, String> photo;
    public static volatile SingularAttribute<User, String> bio;
    public static volatile ListAttribute<User, Kweet> kweets;
    public static volatile SingularAttribute<User, String> location;
    public static volatile SingularAttribute<User, Long> id;
    public static volatile SingularAttribute<User, Account> account;

}