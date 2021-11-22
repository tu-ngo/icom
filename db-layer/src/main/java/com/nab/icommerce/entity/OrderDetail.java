package com.nab.icommerce.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import static org.apache.commons.lang3.Validate.notNull;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

/**
 * An customer order item/product detail
 */

@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = -8129893546494560885L;

    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid")
//    @Column(name = "id", length = 36)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_code", nullable = false)
    private Product product;

    private double price;
    private double quantity;
    private double amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;


    public OrderDetail() {
    }

    public OrderDetail(String productCode,
                       Order order,
                       double price,
                       double quantity,
                       double amount) {
        this.id = UUID.randomUUID().toString();
        this.product = notNull(product, "product can not be null");
        this.order = order;
        this.price = price;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, SHORT_PREFIX_STYLE).toString(this);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final OrderDetail other = (OrderDetail) o;

        return Objects.equals(id, other.id);
    }
}
