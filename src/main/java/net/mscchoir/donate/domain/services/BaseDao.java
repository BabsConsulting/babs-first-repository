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
 * T is the entity type
 * PK is the primary key
 * @author bossbabs
 */
public interface BaseDao <T extends BaseEntity, PK extends Serializable> {

    public void saveOrUpdate(T transientInstance) throws Exception;

    public T findById(PK id) throws Exception;
    
    public List<T> findAll() throws Exception;
    
    public List<T> search(
        final Map<? extends Enum<?>, Object> searchCriteria,
        Class<? extends T> type) throws Exception;

    public List<T> search(
        final Map<? extends Enum<?>, Object> searchCriteria,
        Class<? extends T> type, final Map<String, SortStyle> sort) throws Exception;
    
    public void delete(T persistentInstance) throws Exception;
}

