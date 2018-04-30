package dao;

import domain.*;

import java.util.List;

public interface KweetDao extends GenericDao<Kweet> {

    List<Kweet> findAllKweetsByMessage(String message);

    List<Kweet> findAllKweetsBySender(Long senderId);

    List findAllKweetsByHashtagSubject(String subject);

    List<Kweet> findAllKweetsFromFollowing(Profile Profile);

    List<Kweet> findBySender(Profile sender);
}
