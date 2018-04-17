package dao.jpa;


import dao.GenericDaoJPAImpl;
import dao.HashtagDao;
import dao.JPA;
import domain.Hashtag;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
@JPA
public class HashtagDaoJPA extends GenericDaoJPAImpl<Hashtag> implements HashtagDao {

    public HashtagDaoJPA() {
    }

    @Override
    public List<Hashtag> findByText(String text) {
        return getEntityManager().createNamedQuery("hashtag.findByText", Hashtag.class)
                .setParameter("bodyText", "#" +  text +"%")
                .getResultList();
    }
}
