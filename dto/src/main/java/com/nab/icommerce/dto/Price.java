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

import static org.apache.commons.lang3.Validate.notEmpty;
import static org.apache.commons.lang3.Validate.notNull;

/**
 * Price for a product with effective from start date.
 * The price with latest start date will have a higher priority.
 */
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("price")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Price {
    private String productCode;
    private double price;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private DateTime startDate;

    @JsonCreator
    public Price(@JsonProperty("productCode") String productCode,
                 @JsonProperty("startDate") DateTime startDate,
                 @JsonProperty("price") double price) {
        this.productCode = notEmpty(productCode, "productCode can not be empty");
        this.startDate = notNull(startDate, "startDate can not be null");
        if (price < 0) {
            throw new IllegalArgumentException("price can not be a negative number");
        }
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return ObjectToStringBuilder.defaultToString(this);
    }

}
