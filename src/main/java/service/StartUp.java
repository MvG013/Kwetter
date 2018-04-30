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

        Hashtag hashtagTonijn = new Hashtag("Tonijn");
        Hashtag hashtagArigato = new Hashtag("Arigato");

        //admin
        Account account = new Account();
        account.setUsername("Jens");
        account.setEmail("jensbeek@hotmail.com");
        account.setPassword("Test12!");
        Profile profile = new Profile();
        profile.setFirstName("Jens");
        profile.setLastName("Beek");
        profile.setBirthDay("13-10-1992");
        profile.setLocation("Tilburg");
        profile.setBio("bio Jens test");
        profile.setPhoto("http://pure.au.dk/portal/files/103084444/Jens_Stougaard.jpg");
        profile.setAccount(account);
        account.setProfile(profile);
        accountService.create(account);

        Kweet jensKweet1 = new Kweet("Wahed jens kweetje",profile);
        Kweet jensKweet2 = new Kweet("Wahed jens kweetje2",profile);
        jensKweet1.addHashtag(hashtagTonijn);

        profile.addKweet(jensKweet1);
        profile.addKweet(jensKweet2);

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
        profile2.setBirthDay("13-10-1992");
        profile2.setLocation("Eindhoven");
        profile2.setBio("bio Joost test");
        profile2.setPhoto("https://www.doornroosje.nl/wp-content/uploads/2017/11/Joost.jpg");
        profile2.setAccount(account2);
        account2.setProfile(profile2);
        accountService.create(account2);

        Kweet joostKweet1 = new Kweet("Wahed joost kweetje",profile2);
        Kweet joostKweet2 = new Kweet("Wahed joost kweetje2",profile2);
        joostKweet2.addHashtag(hashtagTonijn);

        profile2.addKweet(joostKweet1);
        profile2.addKweet(joostKweet2);

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
        profile3.setBirthDay("15-12-1899");
        profile3.setLocation("Breda");
        profile3.setBio("bio Henk test");
        profile3.setPhoto("https://www.fullfinance.nl/wp-content/uploads/2014/11/full_finance_henk_aardoom.jpg");
        profile3.setAccount(account3);
        account3.setProfile(profile3);
        accountService.create(account3);

        Kweet henkKweet1 = new Kweet("Wahed henk kweetje",profile3);
        Kweet henkKweet2 = new Kweet("Wahed henk kweetje2",profile3);
        henkKweet2.addHashtag(hashtagArigato);
        henkKweet1.addHashtag(hashtagArigato);

        profile3.addKweet(henkKweet1);
        profile3.addKweet(henkKweet2);



        UserGroup userUserGroup = new UserGroup("userUserGroup");
        userUserGroup.addAccount(account3);
        userGroupService.create(userUserGroup);


//        //followers
        profile.addFollower(profile2);
        profile.addFollower(profile3);
        profile.addFollowing(profile2);
        profile.addFollowing(profile3);
        profileService.update(profile);

        profile2.addFollowing(profile);
        profile2.addFollowing(profile3);
        profile2.addFollower(profile);
        profile2.addFollower(profile3);
        profileService.update(profile2);

        profile3.addFollowing(profile);
        profile3.addFollowing(profile2);
        profile3.addFollower(profile);
        profile3.addFollower(profile2);
        profileService.update(profile3);

    }
}
