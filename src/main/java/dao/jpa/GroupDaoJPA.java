package dao.jpa;

import dao.GenericDaoJPAImpl;
import dao.GroupDao;
import dao.JPA;
import domain.UserGroup;

import javax.ejb.Stateless;

@Stateless
@JPA
public class GroupDaoJPA extends GenericDaoJPAImpl<UserGroup> implements GroupDao {

    public GroupDaoJPA() {
    }

    @Override
    public UserGroup findByGroupName(String groupName) {
        return getEntityManager().createNamedQuery("group.findByGroupName", UserGroup.class)
                .setParameter("groupName", groupName).getSingleResult();
    }
}