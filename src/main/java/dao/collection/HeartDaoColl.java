package dao.collection;

import dao.HeartDao;
import domain.*;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Stateless
@Default
public class HeartDaoColl implements HeartDao {


    CopyOnWriteArrayList<Heart> hearts = new CopyOnWriteArrayList<Heart>();

    @PostConstruct
    private void init() {
    }

    public HeartDaoColl() {
    }

    public Heart findByKweet(Kweet kweet) {
        for (Heart heart : hearts) {
            if (heart.getKweet().equals(kweet)) {
                return heart;
            }
        }
        return null;
    }

    public ArrayList<Heart> getHearts() {
        return new ArrayList<Heart>();
    }

    public Heart create(Heart heart) {
        hearts.add(heart);
        return heart;
    }

    public Heart update(Heart heart) {
        return null;
    }

    public void delete(Heart heart) {
        for (Heart foundHeart : hearts) {
            if (foundHeart.equals(heart)) {
                hearts.remove(foundHeart);
            }
        }
    }

    public void deleteById(Long id) {
        Heart heart = findById(id);
        if (heart != null) {
            hearts.remove(heart);
        }
    }

    public Heart findById(Long id) {
        for (Heart heart : hearts) {
            if (heart.getId().equals(id)) {
                return heart;
            }
        }
        return null;
    }

    public List<Heart> findAll() {
        return hearts;
    }
}