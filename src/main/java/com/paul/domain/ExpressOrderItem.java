package com.paul.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by paulzhang on 25/11/2016.
 *
 * Order Item for each express order
 */
@Entity
public class ExpressOrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** Quantity for this order item */
    private int quantity;

    /** Product this order item is linked to */
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    /** Express order this order item belongs to */
    @ManyToOne
    @JoinColumn(name = "EXPRESS_ORDER_ID")
    private ExpressOrder expressOrder;

    @Override
    public String toString() {
        return "ExpressOrderItem{" +
                "quantity=" + quantity +
                ", product=" + product +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public ExpressOrder getExpressOrder() {
        return expressOrder;
    }

    public void setExpressOrder(ExpressOrder expressOrder) {
        this.expressOrder = expressOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpressOrderItem that = (ExpressOrderItem) o;

        if (id != that.id) return false;
        if (quantity != that.quantity) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        return expressOrder != null ? expressOrder.equals(that.expressOrder) : that.expressOrder == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + quantity;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (expressOrder != null ? expressOrder.hashCode() : 0);
        return result;
    }
}
