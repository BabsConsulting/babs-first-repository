/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mscchoir.donate.domain.services;

import java.util.Date;
import java.util.Map;
import net.mscchoir.donate.domain.entity.Donor;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author bossbabs
 */
public class DonorDao extends DefaultDao<Donor> {

    @Override
    protected void populateCritieria(Map searchCriteria, Criteria criteria) {
        for (DonorSearchType searchType : DonorSearchType.values()) {
            if (searchCriteria.containsKey(searchType)) {
                criteria.add(Restrictions.eq(searchType.getMethodName(), searchCriteria.get(searchType)));
            }
        }
    }
}
