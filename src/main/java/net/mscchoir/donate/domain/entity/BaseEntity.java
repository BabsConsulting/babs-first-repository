package net.mscchoir.donate.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    
    public static final String DEFAULT_USER = "system";
    private static final long serialVersionUID = -4455288936593350735L;
    private Date createdDate;
    private String createdBy = DEFAULT_USER;
    private Date updatedDate;
    private String updatedBy = DEFAULT_USER;

    public BaseEntity() {
      
    }

    @Column(name = "CREATED_BY")
    @NotNull
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "CREATED_TS")
    @Temporal(value = TemporalType.TIMESTAMP)
    @NotNull
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "UPDATED_BY")
    @NotNull
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Column(name = "UPDATED_TS")
    @Temporal(value = TemporalType.TIMESTAMP)
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(final Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public abstract int hashCode(); 
    
    @Override
    public abstract boolean equals(Object object);
}
