package dao.jpa;


import dao.GenericDaoJPAImpl;
import dao.JPA;
import dao.KweetDao;
import domain.*;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
@JPA
public class KweetDaoJPA extends GenericDaoJPAImpl<Kweet> implements KweetDao {

    public KweetDaoJPA() {
    }

    public List<Kweet> findAllKweetsByMessage(String message) {
        return this.entityManager.createNamedQuery("Kweet.findAllKweetsByMessage")
                .setParameter("message", "%" + message + "%").getResultList();
    }

    public List<Kweet> findAllKweetsBySender(Long senderId) {
        return this.entityManager.createNamedQuery("Kweet.findAllKweetsBySender")
                .setParameter("senderId", senderId).getResultList();
    }

    public List<Kweet> findAllKweetsByHashtagSubject(String subject) {
        return this.entityManager.createNamedQuery("Kweet.findAllKweetsByHashtagSubject")
                .setParameter("subject", subject).getResultList();
    }

    public List<Kweet> findAllKweetsFromFollowing(Profile userProfile) {
        return this.entityManager.createNamedQuery("Kweet.findAllKweetsFromFollowing")
                .setParameter("sender", userProfile)
                .setParameter("following", userProfile.getFollowing()).getResultList();
    }

    @Override
    public List<Kweet> findBySender(Profile sender) {
        return getEntityManager().createNamedQuery("kweet.findByAccount", Kweet.class)
                .setParameter("sender", sender)
                .getResultList();
    }


}
