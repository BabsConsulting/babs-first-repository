/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mscchoir.donate.domain.services;

import java.math.BigDecimal;
import net.mscchoir.donate.domain.entity.Donation;
import net.mscchoir.donate.domain.entity.Donor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author bossbabs
 */
public class DonationService extends DefaultService<Donation>{
    @Autowired
    private DonorService donorService;
    public Donation createDonation(Donor donor, BigDecimal amount, String referer) throws Exception
    {
        Donation donation = new Donation();
        donorService.createOrUpdate(donor);
        donation.setAmount(amount);
        donation.setDonor(donor);
        donation.setReferer(referer);
        this.createOrUpdate(donation);
        donor.getDonations().add(donation);
        donorService.createOrUpdate(donor);
        return donation;
    }    
}
