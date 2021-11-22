package com.nab.icommerce.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.nab.icommerce.common.ObjectToStringBuilder;


/**
 * Product - category relationship
 */
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("productCategory")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductCategory {
    private String productCode;
    private String categoryCode;

    @JsonCreator
    public ProductCategory(@JsonProperty("productCode") String productCode,
                           @JsonProperty("categoryCode") String categoryCode) {
        this.productCode = productCode;
        this.categoryCode = categoryCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    @Override
    public String toString() {
        return ObjectToStringBuilder.defaultToString(this);
    }
}
