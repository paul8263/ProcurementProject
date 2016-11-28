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

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", specs='" + specs + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (!productName.equals(product.productName)) return false;
        if (specs != null ? !specs.equals(product.specs) : product.specs != null) return false;
        if (marketPrice != null ? !marketPrice.equals(product.marketPrice) : product.marketPrice != null) return false;
        if (retailPrice != null ? !retailPrice.equals(product.retailPrice) : product.retailPrice != null) return false;
        if (comment != null ? !comment.equals(product.comment) : product.comment != null) return false;
        if (createDate != null ? !createDate.equals(product.createDate) : product.createDate != null) return false;
        if (lastModifyDate != null ? !lastModifyDate.equals(product.lastModifyDate) : product.lastModifyDate != null)
            return false;
        return user != null ? user.equals(product.user) : product.user == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + productName.hashCode();
        result = 31 * result + (specs != null ? specs.hashCode() : 0);
        result = 31 * result + (marketPrice != null ? marketPrice.hashCode() : 0);
        result = 31 * result + (retailPrice != null ? retailPrice.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (lastModifyDate != null ? lastModifyDate.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
