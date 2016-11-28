package com.paul.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by paulzhang on 26/11/2016.
 *
 * Photo ID info is for storing the paths of photo ID images
 */
@Entity
public class PhotoIDInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** The customer who owns this photo ID */
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    /** Path in server pointing to the image file */
    private String path;

    /** Extra info for this photo ID */
    @Lob
    private String comment;

    /** Upload Date for this image */
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Override
    public String toString() {
        return "PhotoIDInfo{" +
                "customer=" + customer +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhotoIDInfo that = (PhotoIDInfo) o;

        if (id != that.id) return false;
        if (customer != null ? !customer.equals(that.customer) : that.customer != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        return createDate != null ? createDate.equals(that.createDate) : that.createDate == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
