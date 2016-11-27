package com.paul.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by paulzhang on 25/11/2016.
 *
 * Express Company we cooperating with
 */
@Entity
public class ExpressCompany implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** Express Company Name*/
    @NotEmpty
    private String name;

    /** URL for querying the shipment status */
    private String shipmentStatusQueryLink;

    /** Date when the express company was entered this system */
    @Temporal(TemporalType.DATE)
    private Date createDate;

    /** If false, this express company would be temporarily hidden */
    private boolean isActive;

    /** Contact number for this express company */
    private String contactNumber;

    /** Address for this express company */
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "expressCompany")
    private List<ExpressPrice> expressPriceList;

    /** User who input this express company */
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
