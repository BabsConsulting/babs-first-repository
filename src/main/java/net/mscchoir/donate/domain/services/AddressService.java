/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mscchoir.donate.domain.services;

import net.mscchoir.donate.domain.entity.Address;
import net.mscchoir.donate.domain.entity.USStateEnum;

/**
 *
 * @author bossbabs
 */
public class AddressService extends DefaultService<Address>{
    private static final String US = "United States";
            
    public Address createUSAddress(String street1, String street2, USStateEnum state, String city, String zip, String zipExtension)
    {
        Address address = createGenericAddress(street1, street2, city);
        address.setUsState(state);
        address.setZip(zip);
        address.setZipExtension(zipExtension);
        return address;
    }
    private Address createGenericAddress(String street1, String street2, String city)
    {
        Address address = new Address();
        address.setStreet1(street1);
        address.setStreet2(street2);
        address.setCity(city);
        address.setCountry(US);
        return address;
    }
    public Address createForeignAddress(String street1, String street2, String city, String province, String postalCode, String country)
    {
        Address address = createGenericAddress(street1, street2, city);
        address.setProvince(province);
        address.setPostalCode(postalCode);
        address.setCountry(country);
        return address;
    }
    
    
}
