package dao;

import domain.Profile;

public interface ProfileDao extends GenericDao<Profile>{

    Profile findByUsername(String username);

}
