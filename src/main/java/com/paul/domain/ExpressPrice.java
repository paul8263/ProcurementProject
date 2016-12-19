package com.paul.domain;

import com.paul.domain.abstractEntity.CreateDateEntity;

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
public class ExpressPrice extends CreateDateEntity {

    /** Product Type for this price */
    private String productType;

    /** Unit price for shipment */
    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    /** The express company it belongs to */
    @ManyToOne
    @JoinColumn(name = "EXPRESS_COMPANY_ID")
    private ExpressCompany expressCompany;

    @Override
    public String toString() {
        return "ExpressPrice{" +
                "productType='" + productType + '\'' +
                ", expressCompany=" + expressCompany +
                '}';
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ExpressCompany getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(ExpressCompany expressCompany) {
        this.expressCompany = expressCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ExpressPrice that = (ExpressPrice) o;

        if (productType != null ? !productType.equals(that.productType) : that.productType != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        return expressCompany != null ? expressCompany.equals(that.expressCompany) : that.expressCompany == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (expressCompany != null ? expressCompany.hashCode() : 0);
        return result;
    }
}
