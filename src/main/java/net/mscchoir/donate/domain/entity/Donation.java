/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mscchoir.donate.domain.entity;

import java.math.BigDecimal;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
/**
 *
 * @author bossbabs
 */
@Entity
@Table(name="DONATION")
public class Donation extends BaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="DONATION_ID")
    private Long id;
    @Column(name="REFERER", nullable = true)
    private String referer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DONOR_ID") 
    private Donor donor;
    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donation)) {
            return false;
        }
        Donation other = (Donation) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.mscchoir.donate.domain.entity.Donation[ id=" + getId() + " ]";
    }

    /**
     * @return the referer
     */
    public String getReferer() {
        return referer;
    }

    /**
     * @param referer the referer to set
     */
    public void setReferer(String referer) {
        this.referer = referer;
    }

    /**
     * @return the donor
     */
    public Donor getDonor() {
        return donor;
    }

    /**
     * @param donor the donor to set
     */
    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
}
