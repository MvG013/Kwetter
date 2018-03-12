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

    public Hashtag findByText(String bodyText) {
        TypedQuery<Hashtag> query = entityManager.createNamedQuery("hashtag.findByBodyText", Hashtag.class);
        query.setParameter("bodyText", bodyText);
        List<Hashtag> result = query.getResultList();
        return result.get(0);
    }
}
