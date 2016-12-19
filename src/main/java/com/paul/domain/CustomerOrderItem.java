package com.paul.domain;

import com.paul.domain.abstractEntity.VersionedEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by paulzhang on 25/11/2016.
 *
 * Item for one customer order
 */
@Entity
public class CustomerOrderItem extends VersionedEntity {

    /** Quantity of this product */
    private int quantity;

    /** Product of the order item */
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    /** Which order it belongs to*/
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ORDER_ID")
    private CustomerOrder customerOrder;

    @Override
    public String toString() {
        return "CustomerOrderItem{" +
                "quantity=" + quantity +
                ", product=" + product +
                '}';
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CustomerOrderItem that = (CustomerOrderItem) o;

        if (quantity != that.quantity) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        return customerOrder != null ? customerOrder.equals(that.customerOrder) : that.customerOrder == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + quantity;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (customerOrder != null ? customerOrder.hashCode() : 0);
        return result;
    }
}
