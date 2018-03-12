package dao;

import domain.Heart;
import domain.Kweet;

import java.util.ArrayList;


public interface HeartDao extends GenericDao<Heart> {

    Heart findByKweet(Kweet kweet);

    ArrayList<Heart> getHearts();
}