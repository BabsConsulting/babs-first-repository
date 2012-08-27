/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mscchoir.donate.domain.services;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import net.mscchoir.donate.domain.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author bossbabs
 */
public abstract class DefaultService<T extends BaseEntity> implements BaseService<T>{
    
    private DefaultDao<T> entityDao;
    
    @Override
    public void createOrUpdate(T entity) throws Exception {
        getEntityDao().saveOrUpdate(entity);
    }

    @Override
    public T getById(Long id) throws Exception {
        return getEntityDao().findById(id);
    }

    @Override
    public List findAll() throws Exception{
        return getEntityDao().findAll();
    }

    @Override
    public List searchByCriteria(Map searchCriteria) throws Exception {
        return entityDao.search(searchCriteria, null);
    }

    /**
     * @return the entityDao
     */
    public DefaultDao<T> getEntityDao() {
        return entityDao;
    }

    /**
     * @param entityDao the entityDao to set
     */
    public void setEntityDao(DefaultDao<T> entityDao) {
        this.entityDao = entityDao;
    }
    
}
