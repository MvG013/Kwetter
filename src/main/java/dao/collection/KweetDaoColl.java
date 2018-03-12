package dao.collection;

import dao.KweetDao;
import domain.*;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;



@Stateless
@Default
public class KweetDaoColl implements KweetDao{

    CopyOnWriteArrayList<Kweet> kweets = new CopyOnWriteArrayList<Kweet>();


    public Kweet create(Kweet kweet) {
        kweets.add(kweet);
        return kweet;
    }

    public Kweet update(Kweet kweet) {
        return null;
    }

    public void delete(Kweet kweet) {
        for (Kweet foundKweet : kweets) {
            if (foundKweet.equals(kweet)) {
                kweets.remove(foundKweet);
            }
        }
    }
    public void deleteById(Long id) {
        Kweet kweet = findById(id);
        if (kweet != null) {
            kweets.remove(kweet);
        }
    }

    public Kweet findById(Long id) {
        for (Kweet kweet : kweets) {
            if (kweet.getId().equals(id)) {
                return kweet;
            }
        }
        return null;
    }

    public List<Kweet> findAll() {
        return kweets;
    }

    public List<Kweet> findBySender(Account sender) {
        return null;
    }
}