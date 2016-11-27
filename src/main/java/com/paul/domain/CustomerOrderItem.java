package com.paul.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by paulzhang on 25/11/2016.
 *
 * Item for one customer order
 */
@Entity
public class CustomerOrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
}
