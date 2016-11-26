package com.paul.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by paulzhang on 25/11/2016.
 */
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** Customer's first name */
    @Column(nullable = false)
    private String firstName;

    /** Customer's last name */
    @Column(nullable = false)
    private String lastName;

    /** Country, part of the address */
    @Column(nullable = false)
    private String country;

    /** Provinces of states  */
    private String province;

    /** City, part of the address */
    private String city;

    /** Rest of the address including street name and number */
    private String address;

    /** Zip code for address */
    private String zipCode;

    /** Date the customer was created */
    private Date createDate;

    /** Identify the state of customer, if the customer will not be used anymore, set this to false */
    private boolean isActive;


    private List<CustomerOrder> customerOrderList = new ArrayList<>();

}
