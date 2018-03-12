package dao;

import domain.*;

import java.util.List;

public interface KweetDao extends GenericDao<Kweet> {

    List<Kweet> findBySender(Account sender);

}
