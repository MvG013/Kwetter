package service;

import dao.JPA;
import dao.KweetDao;
import domain.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Stateless
public class KweetService {

    @Inject
    @JPA
    private KweetDao kweetDao;

    public KweetService() {
    }

    public Kweet create(Kweet kweet) {
        return this.kweetDao.create(kweet);
    }

    public void delete(Long id) {
        this.kweetDao.deleteById(id);
    }

    public List<Kweet> findAll() {
        return this.kweetDao.findAll();
    }

    public void save(Kweet kweet) {
        if (!isNull(kweet)) {
            this.kweetDao.create(kweet);
        }
    }


    public void deleteById(Long id) {
        if (!isNull(id)) {
            this.kweetDao.deleteById(id);
        }
    }

    public void delete(Kweet kweet) {
        if (!isNull(kweet)) {
            this.kweetDao.delete(kweet);
        }
    }

    public Kweet update(Kweet kweet) {
        if (!isNull(kweet)) {
            return this.kweetDao.update(kweet);
        }
        return null;
    }


    public Kweet findById(Long id) {
        if (!isNull(id)) {
            return this.kweetDao.findById(id);
        }
        return null;
    }

    public List<Kweet> findAllKweetsByMessage(String message) {
        if (!isNull(message)) {
            return kweetDao.findAllKweetsByMessage(message);
        }
        return null;
    }

    public List<Kweet> findAllKweetsBySender(Long senderId) {
        return kweetDao.findAllKweetsBySender(senderId);
    }


    public List<Kweet> getAll() {
        return kweetDao.findAll();
    }


    public List<JsonObject> convertAllToJson(List<Kweet> kweets) {
        List<JsonObject> jsonObjects = new ArrayList<JsonObject>();

        for (Kweet kweet : kweets) {
            jsonObjects.add(kweet.toJson());
        }

        return jsonObjects;
    }

    public List<Kweet> findAllKweetsByHashtagSubject(String subject) {
        return kweetDao.findAllKweetsByHashtagSubject(subject);
    }

    public List<Kweet> findAllKweetsFromFollowing(Profile profile) {
        return this.kweetDao.findAllKweetsFromFollowing(profile);
    }

    public List<Kweet> findBySender(Account account) {
        if (!isNull(account)) {
            return this.kweetDao.findBySender(account.getProfile());
        }
        return null;
    }
}