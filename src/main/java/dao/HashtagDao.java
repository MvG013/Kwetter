package dao;

import domain.Hashtag;

import java.util.ArrayList;
import java.util.List;

public interface HashtagDao extends GenericDao<Hashtag>{

    List<Hashtag> findByText(String text);

}
