/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mscchoir.donate.domain.services;

import java.math.BigDecimal;
import net.mscchoir.donate.domain.entity.Donation;
import net.mscchoir.donate.domain.entity.Donor;

/**
 *
 * @author bossbabs
 */
public class DonationService extends DefaultService<Donation>{
    public Donation createDonation(Donor donor, BigDecimal amount, String referer) throws Exception
    {
        Donation donation = new Donation();
        donation.setAmount(amount);
        donation.setDonor(donor);
        donation.setReferer(referer);
        this.createOrUpdate(donation);
        return donation;
    }    
}
