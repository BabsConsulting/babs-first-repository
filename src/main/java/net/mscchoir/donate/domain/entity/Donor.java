/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mscchoir.donate.domain.entity;

import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author bossbabs
 */
@Entity
@Table(name = "DONOR")
public class Donor extends BaseEntity {
    @OneToMany(mappedBy = "donor")
    private Set<Donation> donations;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DONOR_ID")
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @JoinTable(name = "donor_has_address", joinColumns = {
        @JoinColumn(name = "donor_id", referencedColumnName = "donor_id")}, inverseJoinColumns = {
        @JoinColumn(name = "address_id", referencedColumnName = "address_id")})
    @ManyToMany(cascade = {}, fetch = FetchType.LAZY)
    private Set<Address> addresses;
    @Column(name="EMAIL")
    private String email;
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
        if (!(object instanceof Donor)) {
            return false;
        }
        Donor other = (Donor) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.mscchoir.donate.domain.entity.Donor[ id=" + getId() + " ]";
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the addresses
     */
    public Set<Address> getAddresses() {
        return addresses;
    }

    /**
     * @param addresses the addresses to set
     */
    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the donations
     */
    public Set<Donation> getDonations() {
        return donations;
    }

    /**
     * @param donations the donations to set
     */
    public void setDonations(Set<Donation> donations) {
        this.donations = donations;
    }
}
