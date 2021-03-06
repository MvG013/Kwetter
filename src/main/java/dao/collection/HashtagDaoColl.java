package dao.collection;

import dao.HashtagDao;
import domain.Hashtag;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Stateless
@Default
public class HashtagDaoColl implements HashtagDao {

    CopyOnWriteArrayList<Hashtag> hashtags = new CopyOnWriteArrayList<Hashtag>();


    @PostConstruct
    private void init() {
    }

    public HashtagDaoColl() {
    }

    public List<Hashtag> findByText(String text) {
        List<Hashtag> foundHashtags = new ArrayList<Hashtag>();
        for (Hashtag hashtag : hashtags) {
            if (hashtag.getText().contentEquals(text)) {
                foundHashtags.add(hashtag);
            }
            return foundHashtags;
        }
        return null;
    }

    public ArrayList<Hashtag> getHashtags() {
        return new ArrayList<Hashtag>();
    }

    public Hashtag create(Hashtag hashtag) {
        hashtags.add(hashtag);
        return hashtag;
    }

    public Hashtag update(Hashtag hashtag) {
        return null;
    }

    public void delete(Hashtag hashtag) {
        for (Hashtag foundHashtag : hashtags) {
            if (foundHashtag.equals(hashtag)) {
                hashtags.remove(hashtag);
            }
        }
    }

    public void deleteById(Long id) {
        Hashtag hashtag = findById(id);
        if (hashtag != null) {
            hashtags.remove(hashtag);
        }

    }

    public Hashtag findById(Long id) {
        for (Hashtag hashtag : hashtags) {
            if (hashtag.getId().equals(id)) {
                return hashtag;
            }
        }
        return null;
    }

    public List<Hashtag> findAll() {
        return hashtags;
    }

    @Override
    public Long countAll() {
        return null;
    }

    @Override
    public Hashtag findBySubject(String text) {
        return null;
    }
}