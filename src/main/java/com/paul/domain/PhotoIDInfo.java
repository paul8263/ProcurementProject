package com.paul.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by paulzhang on 26/11/2016.
 *
 * Photo ID info is for storing the paths of photo ID images
 */
@Entity
public class PhotoIDInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** The customer who owns this photo ID */
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    /** Path in server pointing to the image file */
    private String path;

    /** Upload Date for this image */
    @Temporal(TemporalType.DATE)
    private Date createDate;
}
