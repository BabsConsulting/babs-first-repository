/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mscchoir.donate.domain.services;

/**
 *
 * @author bossbabs
 */
public enum DonorSearchType {
    FIRST_NAME ("Donor's First Name", "firstName"),
    EMAIL ("Donor's e-mail", "email"),
    LAST_NAME ("Donor's First Name", "lastName");

    private String description;
    private String methodName;
    
    private DonorSearchType(String description, String methodName) {
        this.description = description;
        this.methodName = methodName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getMethodName() {
        return methodName;
    }
    
}
