package com.paul.domain;

import com.paul.domain.abstractEntity.CreateDateEntity;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulzhang on 25/11/2016.
 *
 * Root Object that used for authentication
 */
@Entity
public class User extends CreateDateEntity {

    /** In this system, email works as the username, used in authentication */
    @Column(nullable = false, unique = true)
    @Email
    @NotEmpty
    private String email;

    /** User password */
    @NotEmpty
    @Column(nullable = false)
    private String password;

    /** If this user were deleted or banned or not activated, this value should be false */
    private boolean isActive;

    /** All customers created by this user */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Customer> customerList = new ArrayList<>();

    /** All express company used by this user */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ExpressCompany> expressCompanyList = new ArrayList<>();

    /** All products selling by this user */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Product> productList = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<ExpressCompany> getExpressCompanyList() {
        return expressCompanyList;
    }

    public void setExpressCompanyList(List<ExpressCompany> expressCompanyList) {
        this.expressCompanyList = expressCompanyList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        if (isActive != user.isActive) return false;
        if (!email.equals(user.email)) return false;
        if (!password.equals(user.password)) return false;
        if (customerList != null ? !customerList.equals(user.customerList) : user.customerList != null) return false;
        if (expressCompanyList != null ? !expressCompanyList.equals(user.expressCompanyList) : user.expressCompanyList != null)
            return false;
        return productList != null ? productList.equals(user.productList) : user.productList == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (isActive ? 1 : 0);
        result = 31 * result + (customerList != null ? customerList.hashCode() : 0);
        result = 31 * result + (expressCompanyList != null ? expressCompanyList.hashCode() : 0);
        result = 31 * result + (productList != null ? productList.hashCode() : 0);
        return result;
    }
}
