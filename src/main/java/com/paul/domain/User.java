package com.paul.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by paulzhang on 25/11/2016.
 *
 * Root Object that used for authentication
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** In this system, email works as the username, used in authentication */
    @Column(nullable = false, unique = true)
    @Email
    @NotEmpty
    private String email;

    /** User password */
    @NotEmpty
    @Column(nullable = false)
    private String password;

    /** Date when the user was registered */
    @Temporal(TemporalType.DATE)
    private Date createDate;

    /** If this user were deleted or banned or not activated, this value should be false */
    private boolean isActive;

    /** All customers created by this user */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Customer> customerList = new ArrayList<>();

    /** All express company used by this user */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<ExpressCompany> expressCompanyList = new ArrayList<>();

    /** All products selling by this user */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Product> productList = new ArrayList<>();
}
