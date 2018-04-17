package dao;

import domain.UserGroup;

public interface GroupDao extends GenericDao<UserGroup> {

    UserGroup findByGroupName(String groupName);
}