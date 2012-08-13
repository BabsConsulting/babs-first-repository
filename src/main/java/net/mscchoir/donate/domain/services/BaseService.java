/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mscchoir.donate.domain.services;

import java.util.List;
import java.util.Map;
import net.mscchoir.donate.domain.entity.BaseEntity;

/**
 *
 * @author bossbabs
 */
public interface BaseService<T extends BaseEntity> {

    public void createOrUpdate(final T entity) throws Exception;

    public T getById(final Long id) throws Exception;
    
    public List<T> findAll() throws Exception;
    public List<T> searchByCriteria(final Map<? extends Enum<?>, Object> searchCriteria) throws Exception;
}
