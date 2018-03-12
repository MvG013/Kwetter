package dao;

import domain.Hashtag;

import java.util.ArrayList;

public interface HashtagDao extends GenericDao<Hashtag>{

    Hashtag findByText(String text);

}
