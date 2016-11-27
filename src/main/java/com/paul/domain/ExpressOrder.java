package com.paul.domain;

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

    /** Customer who will receive this parcel */
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    /** All items in this express order */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "expressOrder")
    private List<ExpressOrderItem> expressOrderItemList = new ArrayList<>();
}
