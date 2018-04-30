package service;

import dao.HashtagDao;
import dao.JPA;
import domain.Hashtag;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;


@Stateless
public class HashtagService {

    @Inject
    @JPA
    private HashtagDao hashtagDao;

    public HashtagService() {
    }

    public Hashtag create(Hashtag hashtag) {
        return this.hashtagDao.create(hashtag);
    }

    public Hashtag update(Hashtag hashtag) {
        return this.hashtagDao.update(hashtag);
    }

    public void delete(Hashtag hashtag) {
        this.hashtagDao.delete(hashtag);
    }

    public void delete(Long id) {
        this.hashtagDao.deleteById(id);
    }

    public Hashtag findById(Long id) {
        return this.hashtagDao.findById(id);
    }

    public Hashtag findBySubject(String text) { return this.hashtagDao.findBySubject(text); }

    public List<Hashtag> findAll() {
        return this.hashtagDao.findAll();
    }

    public List<JsonObject> convertAllToJson(List<Hashtag> hashtags) {
        List<JsonObject> convertedHashtags = new ArrayList<JsonObject>();
        for (Hashtag hashtag : hashtags) {
            convertedHashtags.add(hashtag.toJson());
        }
        return convertedHashtags;
    }
}