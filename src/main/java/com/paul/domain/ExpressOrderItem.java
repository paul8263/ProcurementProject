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
}
