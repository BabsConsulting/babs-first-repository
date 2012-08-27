package net.mscchoir.donate.domain.services;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import net.mscchoir.donate.domain.entity.BaseEntity;
import net.mscchoir.donate.util.CustomHibernateDaoSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;


public abstract class DefaultDao<T extends BaseEntity> extends CustomHibernateDaoSupport implements BaseDao<T, Long>
{
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
    

    @Override
    public void saveOrUpdate(T entity) throws Exception {
        if (entity.getCreatedDate() == null) //persist
        {
            preCreate(entity);
            getHibernateTemplate().persist(entity);
        } else {
            preUpdate(entity);
            getHibernateTemplate().merge(entity);
        }
        getHibernateTemplate().flush();
    }

    @Override
    public T findById(Long id) throws Exception {
        final Object obj = getHibernateTemplate().get(type, id);
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


        final Criteria criteria = getSession().createCriteria(typeToSearch);

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
    public List<T> findAll() throws Exception {
        List<T> result = new ArrayList();
        if (type != null) {
            result =  getHibernateTemplate().find(type.getSimpleName() + ".findAll");
        }
        return result;
    }

    @Override
    public List<T> search(Map searchCriteria, Class type) throws Exception {
        return search(searchCriteria, type, null);
    }

    @Override
    public void delete(T entity) throws Exception {
        getHibernateTemplate().delete(entity);
        getHibernateTemplate().flush();
    }

    protected void preCreate(T entity) {
        entity.setCreatedDate(new Date());
    }

    protected void preUpdate(T entity) {
        entity.setUpdatedDate(new Date());
    }
    
    protected abstract void populateCritieria(Map searchCriteria, Criteria criteria);
}