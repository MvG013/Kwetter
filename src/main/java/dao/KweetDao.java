package dao;

import domain.Hashtag;
import domain.Kweet;
import domain.User;

import java.util.ArrayList;

public interface KweetDao {


    /* Kweets */
    void addKweet(Kweet kweet);

    void removeKweet(Kweet kweet);

    ArrayList<Kweet> getKweets();

    ArrayList<Kweet> getRecentKweets();

    ArrayList<Kweet> findKweetsByKeyword();


    /* Mentions */
    void addMention (User user);

    void removeMention (User user);

    ArrayList<User> getMentions();



    /* Hashtags */
    void addHashtag (Hashtag hashtag);

    void removeHashtag (Hashtag hashtag);

    ArrayList<Hashtag> getHashtags();



    /* Likes */
    void addLike (User user);

    void removeLike (User user);

    ArrayList<User> getLikes();


}
