package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Stateless
@JPA
public class GenericDaoJPAImpl<T> implements GenericDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;
    private Class<T> type;

    public GenericDaoJPAImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    public T create(T t) {
        this.entityManager.persist(t);
        return t;
    }

    public T update(T t) {
        return this.entityManager.merge(t);
    }

    public void delete(T t) {
        this.entityManager.remove(this.entityManager.merge(t));
    }

    public void deleteById(Long id) {
        this.delete(findById(id));
    }

    public T findById(Long id) {
        return this.entityManager.find(type, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("SELECT t FROM " + type.getSimpleName() + " t", type).getResultList();
    }

    public Long countAll() {
        return (Long) entityManager.createQuery("SELECT COUNT(entity) FROM " + this.type.getSimpleName() + " entity").getSingleResult();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
