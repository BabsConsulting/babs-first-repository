/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mscchoir.donate.domain.services;

import java.util.List;
import java.util.Map;
import net.mscchoir.donate.domain.entity.Address;
import org.hibernate.Criteria;

/**
 *
 * @author bossbabs
 */
public class AddressDao extends DefaultDao<Address>
{
    @Override
    protected void populateCritieria(Map searchCriteria, Criteria criteria) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
