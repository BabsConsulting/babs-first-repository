package net.mscchoir.donate.domain.services;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import net.mscchoir.donate.domain.entity.Address;
import net.mscchoir.donate.domain.entity.BaseEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 * <p> Base EJB3 DAO Class: is able to create, update, remove, load, and find
 * objects. </p>
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Local({BaseDao.class})
public abstract class DefaultDao<T extends BaseEntity>
        implements BaseDao<T, Long> {

    private Class<? extends T> type;

    public DefaultDao() {
        super();

        // Use reflection to determine which entity class this service deals
        // with
        // Note: we have to handle the weird case of this being a cglib proxy
        Type thisType = getClass().getGenericSuperclass();
        while (thisType instanceof Class) {
            //the while loops up the heirarchy in the case that a class extends a genericised class.
            thisType = ((Class) thisType).getGenericSuperclass();
        } //end while

        final Type localType;
        if (thisType instanceof ParameterizedType) {
            localType = ((ParameterizedType) thisType).getActualTypeArguments()[0];
        } else {
            throw new IllegalArgumentException("Problem handling type construction for " + getClass());
        }

        // handled nested generics (i.e. the BaseEntity is
        // genericised)
        if (localType instanceof Class) {
            this.type = (Class<T>) localType;
        } else if (localType instanceof ParameterizedType) {
            this.type = (Class<T>) ((ParameterizedType) localType).getRawType();
        } else {
            throw new IllegalArgumentException("Problem determining the class of the generic for " + getClass());
        }
    }
    private static final Log LOG = LogFactory.getLog(DefaultDao.class);
    /**
     * Session Context Injection
     */
    @Resource
    protected SessionContext context;
    /**
     * Inject persistence context donateEntityManager
     */
    @PersistenceContext(unitName = "donateEntityManager")
    protected EntityManager emanager;
    @PersistenceContext(unitName = "hibernateSession")
    private Session hibernateSession;

    // For unit testing outside of container - persistence context not injected
    /**
     * @return the context
     */
    public SessionContext getContext() {
        return this.context;
    }

    /**
     * @param contextIn the context to set
     */
    public void setContext(SessionContext contextIn) {
        this.context = contextIn;
    }

    /**
     * @return the emanager
     */
    public EntityManager getEmanager() {
        return this.emanager;
    }

    /**
     * @param emanagerIn the emanager to set
     */
    public void setEmanager(EntityManager emanagerIn) {
        this.emanager = emanagerIn;
    }

    @Override
    public void saveOrUpdate(T entity) throws Exception {
        if (entity.getCreatedDate() == null) //persist
        {
            preCreate(entity);
            emanager.persist(entity);
        } else {
            preUpdate(entity);
            emanager.merge(entity);
        }
        emanager.flush();
    }

    @Override
    public T findById(Long id) throws Exception {
        final Object obj = emanager.find(type, id);
        return (T) obj;
    }

    @Override
    public List<T> search(Map searchCriteria, Class searchType, Map sort) throws Exception {

        List<T> resultList = new ArrayList();

        if (searchCriteria.isEmpty()) {
            return resultList;
        }

        // default to the base type if not specified
        Class typeToSearch = searchType;
        if (typeToSearch == null) {
            typeToSearch = type;
        } // end if


        final Criteria criteria = hibernateSession.createCriteria(typeToSearch);

        populateCritieria(searchCriteria, criteria);

        if (sort != null) {
            for (Object key : sort.keySet()) {
                switch ((SortStyle) sort.get(key)) {
                    case ASC:
                        criteria.addOrder(Order.asc((String) key));
                        break;
                    case DESC:
                        criteria.addOrder(Order.desc((String) key));
                        break;
                }
            }
        }

        resultList = (List<T>) criteria.list();

        if (resultList == null) {
            LOG.debug("get successful, null found");
            resultList = new ArrayList();
        } else if (resultList.isEmpty()) {
            LOG.debug("get successful, no records found");
        } else {
            LOG.trace("get successful, records found");
        } // end if else...

        return resultList;
    }

    @Override
    public List<T> findAll() throws Exception{
        List<T> result = new ArrayList();
        if (type != null) {
            Query query = emanager.createNamedQuery(type.getSimpleName() + ".findAll");
            result = query.getResultList();
        }

        return result;
    }

    @Override
    public List<T> search(Map searchCriteria, Class type) throws Exception {
        return search(searchCriteria, type, null);
    }

    @Override
    public void delete(T entity) throws Exception {
        emanager.remove(entity);
        emanager.flush();
    }

    protected void preCreate(T entity) {
        entity.setCreatedDate(new Date());
    }

    protected void preUpdate(T entity) {
        entity.setUpdatedDate(new Date());
    }

    /**
     * @return the hibernateSession
     */
    public org.hibernate.Session getHibernateSession() {
        return hibernateSession;
    }

    /**
     * @param hibernateSession the hibernateSession to set
     */
    public void setHibernateSession(org.hibernate.Session hibernateSession) {
        this.hibernateSession = hibernateSession;
    }

    protected abstract void populateCritieria(Map searchCriteria, Criteria criteria);
}