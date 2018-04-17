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

    @Override
    public List<Kweet> findBySender(Account sender) {
        return getEntityManager().createNamedQuery("kweet.findByAccount", Kweet.class)
                .setParameter("sender", sender)
                .getResultList();
    }

    public List<Kweet> findByText(String bodyText) {
        return getEntityManager().createNamedQuery("kweet.findByBodyText", Kweet.class)
                .setParameter("bodyText", "%" +  bodyText + "%")
                .getResultList();
    }

    public List<Kweet> findByMention(Profile mention) {
        return getEntityManager().createNamedQuery("kweet.findByMention", Kweet.class)
                .setParameter("mention", mention)
                .getResultList();
    }

}
