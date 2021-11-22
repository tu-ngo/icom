package com.nab.icommerce.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.nab.icommerce.common.ObjectToStringBuilder;

/**
 * Product - color relationship
 */
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("productColor")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductColor {
    private String productCode;
    private String colorCode;

    public ProductColor(@JsonProperty("productCode") String productCode,
                        @JsonProperty("colorCode") String colorCode) {
        this.productCode = productCode;
        this.colorCode = colorCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getColorCode() {
        return colorCode;
    }

    @Override
    public String toString() {
        return ObjectToStringBuilder.defaultToString(this);
    }
}
