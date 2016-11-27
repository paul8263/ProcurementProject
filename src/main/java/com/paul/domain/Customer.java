package com.paul.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by paulzhang on 25/11/2016.
 *
 * Customer stores information who orders product.
 */
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** Customer's first name */
    @NotEmpty
    @Column(nullable = false)
    private String firstName;

    /** Customer's last name */
    @Column(nullable = false)
    private String lastName;

    /** Country, part of the address */
    @Column(nullable = false)
    private String country;

    /** Province or state  */
    private String province;

    /** City, part of the address */
    private String city;

    /** Rest of the address including street name and number */
    private String address;

    /** Zip code for address */
    private String zipCode;

    /** Contact number for the customer */
    private String phoneNumber;

    /** ID for the customer */
    private String idNumber;

    /** Date the customer was created */
    @Temporal(TemporalType.DATE)
    private Date createDate;

    /** Extra information for this customer */
    @Lob
    private String comment;

    /** Identify the state of customer, if the customer will not be used anymore, set this to false */
    private boolean isActive;

    /** Store photo ID image paths for the customer */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<PhotoIDInfo> photoIDInfoList = new ArrayList<>();

    /** Store all orders belong to this customer */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<CustomerOrder> customerOrderList = new ArrayList<>();

    /** Store All express orders belong to this customer */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<ExpressOrder> expressOrderList = new ArrayList<>();

    /** User this customer is linked to */
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<PhotoIDInfo> getPhotoIDInfoList() {
        return photoIDInfoList;
    }

    public void setPhotoIDInfoList(List<PhotoIDInfo> photoIDInfoList) {
        this.photoIDInfoList = photoIDInfoList;
    }

    public List<CustomerOrder> getCustomerOrderList() {
        return customerOrderList;
    }

    public void setCustomerOrderList(List<CustomerOrder> customerOrderList) {
        this.customerOrderList = customerOrderList;
    }

    public List<ExpressOrder> getExpressOrderList() {
        return expressOrderList;
    }

    public void setExpressOrderList(List<ExpressOrder> expressOrderList) {
        this.expressOrderList = expressOrderList;
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

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (isActive != customer.isActive) return false;
        if (!firstName.equals(customer.firstName)) return false;
        if (!lastName.equals(customer.lastName)) return false;
        if (!country.equals(customer.country)) return false;
        if (province != null ? !province.equals(customer.province) : customer.province != null) return false;
        if (city != null ? !city.equals(customer.city) : customer.city != null) return false;
        if (address != null ? !address.equals(customer.address) : customer.address != null) return false;
        if (zipCode != null ? !zipCode.equals(customer.zipCode) : customer.zipCode != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(customer.phoneNumber) : customer.phoneNumber != null)
            return false;
        if (idNumber != null ? !idNumber.equals(customer.idNumber) : customer.idNumber != null) return false;
        if (createDate != null ? !createDate.equals(customer.createDate) : customer.createDate != null) return false;
        if (comment != null ? !comment.equals(customer.comment) : customer.comment != null) return false;
        if (photoIDInfoList != null ? !photoIDInfoList.equals(customer.photoIDInfoList) : customer.photoIDInfoList != null)
            return false;
        if (customerOrderList != null ? !customerOrderList.equals(customer.customerOrderList) : customer.customerOrderList != null)
            return false;
        if (expressOrderList != null ? !expressOrderList.equals(customer.expressOrderList) : customer.expressOrderList != null)
            return false;
        return user != null ? user.equals(customer.user) : customer.user == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (idNumber != null ? idNumber.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (isActive ? 1 : 0);
        result = 31 * result + (photoIDInfoList != null ? photoIDInfoList.hashCode() : 0);
        result = 31 * result + (customerOrderList != null ? customerOrderList.hashCode() : 0);
        result = 31 * result + (expressOrderList != null ? expressOrderList.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
