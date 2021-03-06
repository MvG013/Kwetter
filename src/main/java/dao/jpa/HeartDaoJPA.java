package dao.jpa;

import dao.GenericDaoJPAImpl;
import dao.HeartDao;
import dao.JPA;
import domain.Heart;
import domain.Kweet;

import javax.ejb.Stateless;
import java.util.List;


@Stateless
@JPA
public class HeartDaoJPA extends GenericDaoJPAImpl<Heart> implements HeartDao {

    public HeartDaoJPA() {
    }

    public List<Heart> findByKweet(Kweet kweet) {
        return getEntityManager().createNamedQuery("heart.findByKweet", Heart.class)
                .setParameter("kweet", kweet)
                .getResultList();
    }
}