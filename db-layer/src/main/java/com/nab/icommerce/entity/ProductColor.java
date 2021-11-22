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
 * Product - color relationship
 */
@Entity
@Table(name = "product_color")
@IdClass(ProductColor.class)
public class ProductColor implements Serializable {
    private static final long serialVersionUID = 8597314616197939858L;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "color_code")
    private Color color;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_code", nullable = false)
    private Product product;


    public ProductColor(Color color, Product product) {
        this.color = color;
        this.product = product;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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

        final ProductColor other = (ProductColor) o;

        return Objects.equals(product, other.product) &&
                Objects.equals(color, other.color);
    }
}
