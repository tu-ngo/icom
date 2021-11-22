package com.nab.icommerce.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.nab.icommerce.common.ObjectToStringBuilder;

import java.util.UUID;

import static org.apache.commons.lang3.Validate.notEmpty;

/**
 * An customer order item/product detail
 */

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("orderDetail")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDetail {
    private String id;
    private String productCode;
    private String orderId;
    private double price;
    private double quantity;
    private double amount;

    @JsonCreator
    public OrderDetail(@JsonProperty("productCode") String productCode,
                       @JsonProperty("orderId") String orderId,
                       @JsonProperty("price") double price,
                       @JsonProperty("quantity") double quantity,
                       @JsonProperty("amount") double amount) {
        this.id = UUID.randomUUID().toString();
        this.productCode = notEmpty(productCode, "productCode can not be empty");
        this.orderId = orderId;
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

    public String getProductCode() {
        return productCode;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return ObjectToStringBuilder.defaultToString(this);
    }

}
