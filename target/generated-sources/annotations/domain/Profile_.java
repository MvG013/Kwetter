package domain;

import domain.Account;
import domain.Kweet;
import domain.Profile;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-23T16:44:13")
@StaticMetamodel(Profile.class)
public class Profile_ { 

    public static volatile SingularAttribute<Profile, String> lastName;
    public static volatile SingularAttribute<Profile, String> birthDay;
    public static volatile SingularAttribute<Profile, String> website;
    public static volatile SingularAttribute<Profile, String> photo;
    public static volatile SingularAttribute<Profile, String> bio;
    public static volatile ListAttribute<Profile, Kweet> mentionKweets;
    public static volatile SingularAttribute<Profile, String> firstName;
    public static volatile ListAttribute<Profile, Profile> followers;
    public static volatile ListAttribute<Profile, Profile> following;
    public static volatile ListAttribute<Profile, Kweet> kweets;
    public static volatile SingularAttribute<Profile, String> location;
    public static volatile SingularAttribute<Profile, Long> id;
    public static volatile SingularAttribute<Profile, Account> account;

}