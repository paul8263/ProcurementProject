package com.paul.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by paulzhang on 25/11/2016.
 *
 * Express order, store all info during shipment
 */
@Entity
public class ExpressOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** Order Number*/
    @NotEmpty
    private String orderNumber;

    /** Specify the date when the parcel was mailed */
    @Temporal(TemporalType.DATE)
    private Date sendDate;

    /** Specify the date when this express order was entered in this system */
    @Temporal(TemporalType.DATE)
    private Date inputDate;

    /** Specify the date when the parcel was delivered */
    @Temporal(TemporalType.DATE)
    private Date deliveredDate;

    /** Whether the parcel has been delivered */
    private boolean isDelivered;

    /** Total weight for this parcel, precision is 6 and fraction is 2 */
    @Column(precision = 6, scale = 2)
    private BigDecimal totalWeight;

    /** Total cost for one express order */
    @Column(precision = 10, scale = 2)
    private BigDecimal totalCost;

    /** Path for the photo copy of this express order */
    private String imagePath;

    /** Customer who will receive this parcel */
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    /** All items in this express order */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "expressOrder", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ExpressOrderItem> expressOrderItemList = new ArrayList<>();

    @Override
    public String toString() {
        return "ExpressOrder{" +
                "orderNumber='" + orderNumber + '\'' +
                ", customer=" + customer +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public BigDecimal getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(BigDecimal totalWeight) {
        this.totalWeight = totalWeight;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ExpressOrderItem> getExpressOrderItemList() {
        return expressOrderItemList;
    }

    public void setExpressOrderItemList(List<ExpressOrderItem> expressOrderItemList) {
        this.expressOrderItemList = expressOrderItemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpressOrder that = (ExpressOrder) o;

        if (id != that.id) return false;
        if (isDelivered != that.isDelivered) return false;
        if (!orderNumber.equals(that.orderNumber)) return false;
        if (sendDate != null ? !sendDate.equals(that.sendDate) : that.sendDate != null) return false;
        if (inputDate != null ? !inputDate.equals(that.inputDate) : that.inputDate != null) return false;
        if (deliveredDate != null ? !deliveredDate.equals(that.deliveredDate) : that.deliveredDate != null)
            return false;
        if (totalWeight != null ? !totalWeight.equals(that.totalWeight) : that.totalWeight != null) return false;
        if (totalCost != null ? !totalCost.equals(that.totalCost) : that.totalCost != null) return false;
        if (imagePath != null ? !imagePath.equals(that.imagePath) : that.imagePath != null) return false;
        if (customer != null ? !customer.equals(that.customer) : that.customer != null) return false;
        return expressOrderItemList != null ? expressOrderItemList.equals(that.expressOrderItemList) : that.expressOrderItemList == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + orderNumber.hashCode();
        result = 31 * result + (sendDate != null ? sendDate.hashCode() : 0);
        result = 31 * result + (inputDate != null ? inputDate.hashCode() : 0);
        result = 31 * result + (deliveredDate != null ? deliveredDate.hashCode() : 0);
        result = 31 * result + (isDelivered ? 1 : 0);
        result = 31 * result + (totalWeight != null ? totalWeight.hashCode() : 0);
        result = 31 * result + (totalCost != null ? totalCost.hashCode() : 0);
        result = 31 * result + (imagePath != null ? imagePath.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (expressOrderItemList != null ? expressOrderItemList.hashCode() : 0);
        return result;
    }
}
