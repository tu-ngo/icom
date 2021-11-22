package com.nab.icommerce.entity;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;


/**
 * Product - brand relationship
 */
@Entity
@Table(name = "product_brand")
@IdClass(ProductBrand.class)
public class ProductBrand implements Serializable {
    private static final long serialVersionUID = -6302524118840650634L;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_code")
    private Brand brand;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_code", nullable = false)
    private Product product;

    public ProductBrand() {
    }

    public ProductBrand(Brand brand, Product product) {
        this.brand = brand;
        this.product = product;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, SHORT_PREFIX_STYLE).toString(this);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final ProductBrand other = (ProductBrand) o;

        return Objects.equals(product, other.product) &&
                Objects.equals(brand, other.brand);
    }
}
