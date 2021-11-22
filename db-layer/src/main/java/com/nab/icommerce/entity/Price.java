package com.nab.icommerce.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

import static org.apache.commons.lang3.Validate.notNull;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

/**
 * Price for a product with effective from start date.
 * The price with latest start date will have a higher priority.
 */
@Entity
@Table(name = "price")
public class Price implements Serializable {
    private static final long serialVersionUID = 1026721754834366247L;

    private double price;

    @Id
    @Column(name = "start_date", columnDefinition = "DATETIME")
    private DateTime startDate;

    @PrimaryKeyJoinColumn(name = "product_code")
    private Product product;

    public Price() {
    }

    public Price(Product product,
                 DateTime startDate,
                 double price) {
        this.product = notNull(product, "product can not be null");
        this.startDate = notNull(startDate, "startDate can not be null");
        if (price < 0) {
            throw new IllegalArgumentException("price can not be a negative number");
        }
        this.price = price;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
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

        final Price other = (Price) o;

        return Objects.equals(product, other.product) && Objects.equals(startDate, other.startDate);
    }
}
