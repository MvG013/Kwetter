package service;
import com.mysql.jdbc.StringUtils;
import dao.JPA;
import dao.GroupDao;
import domain.UserGroup;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;


@Stateless
public class UserGroupService {

    @Inject
    @JPA
    private GroupDao groupDao;

    public UserGroupService() {
    }

    public UserGroup findByGroupName(String groupName) {
        if (!StringUtils.isNullOrEmpty(groupName)) {
            return this.groupDao.findByGroupName(groupName);
        }
        return null;
    }

    public UserGroup create(UserGroup userGroup) {
        return this.groupDao.create(userGroup);
    }

    public void update(UserGroup userGroup) {
        if (userGroup != null) {
            this.groupDao.update(userGroup);
        }
    }

    public List<UserGroup> findAll() {
        return this.groupDao.findAll();
    }
}