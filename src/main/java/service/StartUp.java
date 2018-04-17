package service;

import domain.*;
import util.Hashing;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;


@Singleton
@Startup
public class StartUp {

    @Inject
    private AccountService accountService;
    @Inject
    private ProfileService profileService;
    @Inject
    private UserGroupService userGroupService;


    public StartUp() {
    }


    @PostConstruct
    private void init(){

        //admin
        Account account = new Account();
        account.setUsername("Jens");
        account.setEmail("jensbeek@hotmail.com");
        account.setPassword("Test12!");
        Profile profile = new Profile();
        profile.setFirstName("Jens");
        profile.setLastName("Beek");
        account.setProfile(profile);
        accountService.create(account);

        UserGroup adminUserGroup = new UserGroup("adminUserGroup");
        adminUserGroup.addAccount(account);
        userGroupService.create(adminUserGroup);


        //moderator
        Account account2 = new Account();
        account2.setUsername("Joost");
        account2.setEmail("Joostenbrood@hotmail.com");
        account2.setPassword("Test12!");
        Profile profile2 = new Profile();
        profile2.setFirstName("Joost");
        profile2.setLastName("Brood");
        account2.setProfile(profile2);
        accountService.create(account2);

        UserGroup moderatorUserGroup = new UserGroup("moderatorUserGroup");
        moderatorUserGroup.addAccount(account2);
        userGroupService.create(moderatorUserGroup);


        //user
        Account account3 = new Account();
        account3.setUsername("Henk");
        account3.setEmail("Henkjonge@hotmail.com");
        account3.setPassword("Test12!");
        Profile profile3 = new Profile();
        profile3.setFirstName("Henk");
        profile3.setLastName("Jonge");
        account3.setProfile(profile3);
        accountService.create(account3);

        UserGroup userUserGroup = new UserGroup("userUserGroup");
        userUserGroup.addAccount(account3);
        userGroupService.create(userUserGroup);

        Profile testProfile = new Profile();
        testProfile.setAccount(account3);
        testProfile.setFirstName("Rens");
        testProfile.setLastName("Joolen");
        testProfile.setBio("bio test test");
        testProfile.setPhoto("https://www.fullfinance.nl/wp-content/uploads/2014/11/full_finance_henk_aardoom.jpg");


        Kweet kweet = new Kweet("Dit is een test Kweet", testProfile);
        testProfile.addKweet(kweet);

        Heart heart = new Heart(kweet, testProfile);
        kweet.addHeart(heart);

        Hashtag hashtag = new Hashtag("#Duinrell");
        kweet.addHashtag(hashtag);

        profileService.create(testProfile);
        testProfile.setLocation("Duinrell");
        profileService.update(testProfile);
        profile.setAccount(account);
        profile.setLocation("Kikibad");
        profile.setBio("Duinrell daar kikker je van op");
        profile.setPhoto("http://lz1886.nl/wp-content/uploads/2016/09/Frontaal_Rick_de_Kikker-e1474828617272-210x210.jpg");
        profileService.update(profile);
    }
}
