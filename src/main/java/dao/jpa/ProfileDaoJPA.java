package dao.jpa;


import dao.GenericDaoJPAImpl;
import dao.JPA;
import dao.ProfileDao;
import domain.Profile;

import javax.ejb.Stateless;

@Stateless
@JPA
public class ProfileDaoJPA extends GenericDaoJPAImpl<Profile> implements ProfileDao {

    public ProfileDaoJPA() {
    }

    public Profile findByUsername(String username) {
        return getEntityManager().createNamedQuery("profile.findByUsername", Profile.class)
                .setParameter("username", username)
                .getSingleResult();
    }
}
