package com.paul.domain;

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
public class CustomerOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** The date when the order was entered in the website */
    @Temporal(TemporalType.DATE)
    private Date createDate;

    /** Extra information for customer order */
    @Lob
    private String comment;

    /** Marker for the state of this customer order */
    private boolean isActive;

    /** Store all customer order items */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerOrder")
    private List<CustomerOrderItem> customerOrderItemList = new ArrayList<>();

    /** Customer who owns this customer order */
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "createDate=" + createDate +
                ", customer=" + customer +
                '}';
    }
}
