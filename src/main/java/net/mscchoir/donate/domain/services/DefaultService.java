/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mscchoir.donate.domain.services;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import net.mscchoir.donate.domain.entity.BaseEntity;

/**
 *
 * @author bossbabs
 */
public abstract class DefaultService<T extends BaseEntity> implements BaseService<T>{

    protected DefaultDao<T> entityDao;
    
    @Override
    public void createOrUpdate(T entity) throws Exception {
       entityDao.saveOrUpdate(entity);
    }

    @Override
    public T getById(Long id) throws Exception {
        return entityDao.findById(id);
    }

    @Override
    public List findAll() throws Exception{
        return entityDao.findAll();
    }

    @Override
    public List searchByCriteria(Map searchCriteria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
