package com.paul.domain;

import com.paul.domain.abstractEntity.CreateDateEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by paulzhang on 25/11/2016.
 *
 * Customer order is to store product list before we actually mail them.
 */
@Entity
public class CustomerOrder extends CreateDateEntity {

    /** Extra information for customer order */
    @Lob
    private String comment;

    /** Marker for the state of this customer order */
    private boolean isActive;

    /** Store all customer order items */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerOrder", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<CustomerOrderItem> customerOrderItemList = new ArrayList<>();

    /** Customer who owns this customer order */
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "createDate=" + getCreateDate() +
                ", customer=" + customer +
                '}';
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

    public List<CustomerOrderItem> getCustomerOrderItemList() {
        return customerOrderItemList;
    }

    public void setCustomerOrderItemList(List<CustomerOrderItem> customerOrderItemList) {
        this.customerOrderItemList = customerOrderItemList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CustomerOrder that = (CustomerOrder) o;

        if (isActive != that.isActive) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (customerOrderItemList != null ? !customerOrderItemList.equals(that.customerOrderItemList) : that.customerOrderItemList != null)
            return false;
        return customer != null ? customer.equals(that.customer) : that.customer == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (isActive ? 1 : 0);
        result = 31 * result + (customerOrderItemList != null ? customerOrderItemList.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        return result;
    }
}
