package service;

import dao.HashtagDao;
import dao.JPA;
import domain.Hashtag;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;


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

    public Hashtag findByText(String text) { return this.hashtagDao.findByText(text); }

    public List<Hashtag> findAll() {
        return this.hashtagDao.findAll();
    }
}