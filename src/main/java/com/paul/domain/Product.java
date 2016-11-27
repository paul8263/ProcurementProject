package com.paul.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by paulzhang on 25/11/2016.
 *
 * Product of what we are available to sale
 */
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** Product name */
    @NotEmpty
    private String productName;

    /** Product specs, such as net weight, number of capsules per bottle */
    private String specs;

    /** Unit market price */
    @Column(precision = 10, scale = 2)
    private BigDecimal marketPrice;

    /** Price we offer */
    @Column(precision = 10, scale = 2)
    private BigDecimal retailPrice;

    /** Extra information for this product */
    @Lob
    private String comment;

    /** Date when this product was entered */
    @Temporal(TemporalType.DATE)
    private Date createDate;

    /** Last date of this product was modified */
    @Temporal(TemporalType.DATE)
    private Date lastModifyDate;

    /** User who owns this product */
    @ManyToOne
    @JoinColumn(name = "USER")
    private User user;
}
