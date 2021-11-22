package com.nab.icommerce.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.nab.icommerce.common.ObjectToStringBuilder;
import org.joda.time.DateTime;

import java.util.UUID;

/**
 * An customer order
 */
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("order")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
    private String id;
    private String description;


    private String createdBy;
    private double amount;

    // Customer info
    private String customerAddress;
    private String customerEmail;
    private String customerPhone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private DateTime orderDate;
    private int orderNumber;

    @JsonCreator
    public Order(@JsonProperty("description") String description,
                 @JsonProperty("createdBy") String createdBy,
                 @JsonProperty("amount") double amount,
                 @JsonProperty("customerAddress") String customerAddress,
                 @JsonProperty("customerEmail") String customerEmail,
                 @JsonProperty("customerPhone") String customerPhone,
                 @JsonProperty("orderDate") DateTime orderDate,
                 @JsonProperty("orderNumber") int orderNumber) {
        this.id =  UUID.randomUUID().toString();
        this.description = description;
        this.createdBy = createdBy;
        this.amount = amount;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.orderDate = orderDate;
        this.orderNumber = orderNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public double getAmount() {
        return amount;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public DateTime getOrderDate() {
        return orderDate;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String toString() {
        return ObjectToStringBuilder.defaultToString(this);
    }

}
