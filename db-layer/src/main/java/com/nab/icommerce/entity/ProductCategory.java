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
 * Product - category relationship
 */
@Entity
@Table(name = "product_category")
@IdClass(ProductCategory.class)
public class ProductCategory implements Serializable {
    private static final long serialVersionUID = -3769728098155286355L;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "category_code", nullable = false)
    private Category category;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_code", nullable = false)
    private Product product;

    public ProductCategory() {
    }

    public ProductCategory(Category category, Product product) {
        this.category = category;
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

        final ProductCategory other = (ProductCategory) o;

        return Objects.equals(product, other.product) &&
                Objects.equals(category, other.category);
    }
}
