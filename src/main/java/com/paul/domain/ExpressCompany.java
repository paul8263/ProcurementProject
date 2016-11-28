package com.paul.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by paulzhang on 25/11/2016.
 *
 * Express Company we cooperating with
 */
@Entity
public class ExpressCompany implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** Express Company Name*/
    @NotEmpty
    private String name;

    /** URL for querying the shipment status */
    private String shipmentStatusQueryLink;

    /** Date when the express company was entered this system */
    @Temporal(TemporalType.DATE)
    private Date createDate;

    /** If false, this express company would be temporarily hidden */
    private boolean isActive;

    /** Contact number for this express company */
    private String contactNumber;

    /** Address for this express company */
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "expressCompany")
    private List<ExpressPrice> expressPriceList;

    /** User who input this express company */
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Override
    public String toString() {
        return "ExpressCompany{" +
                "name='" + name + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShipmentStatusQueryLink() {
        return shipmentStatusQueryLink;
    }

    public void setShipmentStatusQueryLink(String shipmentStatusQueryLink) {
        this.shipmentStatusQueryLink = shipmentStatusQueryLink;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ExpressPrice> getExpressPriceList() {
        return expressPriceList;
    }

    public void setExpressPriceList(List<ExpressPrice> expressPriceList) {
        this.expressPriceList = expressPriceList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpressCompany that = (ExpressCompany) o;

        if (id != that.id) return false;
        if (isActive != that.isActive) return false;
        if (!name.equals(that.name)) return false;
        if (shipmentStatusQueryLink != null ? !shipmentStatusQueryLink.equals(that.shipmentStatusQueryLink) : that.shipmentStatusQueryLink != null)
            return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (contactNumber != null ? !contactNumber.equals(that.contactNumber) : that.contactNumber != null)
            return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (expressPriceList != null ? !expressPriceList.equals(that.expressPriceList) : that.expressPriceList != null)
            return false;
        return user != null ? user.equals(that.user) : that.user == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + (shipmentStatusQueryLink != null ? shipmentStatusQueryLink.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (isActive ? 1 : 0);
        result = 31 * result + (contactNumber != null ? contactNumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (expressPriceList != null ? expressPriceList.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
