package com.paul.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by paulzhang on 25/11/2016.
 *
 * Unit price of shipment for each express company
 */
@Entity
public class ExpressPrice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** Product Type for this price */
    private String productType;

    /** Unit price for shipment */
    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    /** Date when this price was added in the system*/
    @Temporal(TemporalType.DATE)
    private Date inputDate;

    /** The express company it belongs to */
    @ManyToOne
    @JoinColumn(name = "EXPRESS_COMPANY_ID")
    private ExpressCompany expressCompany;
}
