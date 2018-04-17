package domain;

import domain.Account;
import domain.Kweet;
import domain.Profile;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-05T16:23:37")
@StaticMetamodel(Profile.class)
public class Profile_ { 

    public static volatile SingularAttribute<Profile, String> firstName;
    public static volatile SingularAttribute<Profile, String> lastName;
    public static volatile SingularAttribute<Profile, String> website;
    public static volatile ListAttribute<Profile, Profile> followers;
    public static volatile SingularAttribute<Profile, String> photo;
    public static volatile SingularAttribute<Profile, String> bio;
    public static volatile ListAttribute<Profile, Kweet> kweets;
    public static volatile SingularAttribute<Profile, String> location;
    public static volatile SingularAttribute<Profile, Long> id;
    public static volatile SingularAttribute<Profile, Account> account;

}