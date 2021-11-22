package com.nab.icommerce.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.nab.icommerce.common.ObjectToStringBuilder;


/**
 * Product - brand relationship
 */
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("productBrand")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductBrand {
    private String productCode;
    private String brandCode;


    @JsonCreator
    public ProductBrand(@JsonProperty("productCode") String productCode,
                        @JsonProperty("brandCode") String brandCode) {
        this.productCode = productCode;
        this.brandCode = brandCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getBrandCode() {
        return brandCode;
    }

    @Override
    public String toString() {
        return ObjectToStringBuilder.defaultToString(this);
    }
}
