package dao;

import domain.Heart;
import domain.Kweet;

import java.util.ArrayList;
import java.util.List;


public interface HeartDao extends GenericDao<Heart> {

    List<Heart> findByKweet(Kweet kweet);

}