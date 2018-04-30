package service;

import dao.JPA;
import dao.ProfileDao;
import domain.Profile;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;


@Stateless
public class ProfileService {

    @Inject
    @JPA
    private ProfileDao profileDao;

    public ProfileService() {
    }

    public Profile create(Profile profile) {
        return this.profileDao.create(profile);
    }

    public Profile update(Profile profile) {
        if (!isNull(profile)) {
            return this.profileDao.update(profile);
        }
        return null;
    }

    public void delete(Profile profile) {
        this.profileDao.delete(profile);
    }

    public void delete(Long id) {
        this.profileDao.deleteById(id);
    }

    public Profile findById(Long id) {
        return this.profileDao.findById(id);
    }

    public List<Profile> findAll() {
        return this.profileDao.findAll();
    }

    public Profile findByUsername(String username) {
        if (!isNull(username)) {
            return this.profileDao.findByUsername(username);
        }
        return null;
    }

    public List<JsonObject> convertAllToJson(List<Profile> userProfiles) {
        List<JsonObject> jsonObjects = new ArrayList<JsonObject>();

        for (Profile profile : userProfiles) {
            jsonObjects.add(profile.toJson());
        }

        return jsonObjects;
    }

    public Long countAll() {
        return profileDao.countAll();
    }

}