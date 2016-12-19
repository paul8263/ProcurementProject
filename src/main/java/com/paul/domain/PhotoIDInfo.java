package com.paul.domain;

import com.paul.domain.abstractEntity.CreateDateEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by paulzhang on 26/11/2016.
 *
 * Photo ID info is for storing the paths of photo ID images
 */
@Entity
public class PhotoIDInfo extends CreateDateEntity {

    /** The customer who owns this photo ID */
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    /** Path in server pointing to the image file */
    private String path;

    /** Extra info for this photo ID */
    @Lob
    private String comment;

    @Override
    public String toString() {
        return "PhotoIDInfo{" +
                "customer=" + customer +
                '}';
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PhotoIDInfo that = (PhotoIDInfo) o;

        if (customer != null ? !customer.equals(that.customer) : that.customer != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        return comment != null ? comment.equals(that.comment) : that.comment == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }
}
