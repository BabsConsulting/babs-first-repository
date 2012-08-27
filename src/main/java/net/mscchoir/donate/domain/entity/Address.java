/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mscchoir.donate.domain.entity;

import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author bossbabs
 */
@Entity
@Table(name = "ADDRESS")
public class Address extends BaseEntity {

    @ManyToMany(mappedBy = "addresses", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "donor_has_address", joinColumns = {
        @JoinColumn(name = "address_id", referencedColumnName = "address_id")}, inverseJoinColumns = {
        @JoinColumn(name = "donor_id", referencedColumnName = "donor_id")})
    @Cascade({org.hibernate.annotations.CascadeType.REPLICATE})
    private List<Donor> donors;
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Column(name = "ADDRESS_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "STREET_1", length = 50, nullable = false)
    private String street1;
    @Column(name = "STREET_2", length = 50, nullable = true)
    private String street2;
    @Column(name = "US_STATE", length = 50, nullable = true)
    @Enumerated(value = EnumType.STRING)
    private USStateEnum usState;
    @Column(name = "ZIP", length = 5)
    private String zip;
    @Column(name = "ZIP_EXTENSION", length = 4)
    private String zipExtension;
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Column(name = "CITY")
    private String city;
    @Column(name = "PROVINCE")
    private String province;
    @Column(name = "COUNTRY")
    private String country;

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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.mscchoir.donate.domain.entity.Address[ id=" + getId() + " ]";
    }

    /**
     * @return the street1
     */
    public String getStreet1() {
        return street1;
    }

    /**
     * @param street1 the street1 to set
     */
    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    /**
     * @return the street2
     */
    public String getStreet2() {
        return street2;
    }

    /**
     * @param street2 the street2 to set
     */
    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    /**
     * @return the usState
     */
    public USStateEnum getUsState() {
        return usState;
    }

    /**
     * @param usState the usState to set
     */
    public void setUsState(USStateEnum usState) {
        this.usState = usState;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return the zipExtension
     */
    public String getZipExtension() {
        return zipExtension;
    }

    /**
     * @param zipExtension the zipExtension to set
     */
    public void setZipExtension(String zipExtension) {
        this.zipExtension = zipExtension;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the donors
     */
    public List<Donor> getDonors() {
        return donors;
    }

    /**
     * @param donors the donors to set
     */
    public void setDonors(List<Donor> donors) {
        this.donors = donors;
    }
}
