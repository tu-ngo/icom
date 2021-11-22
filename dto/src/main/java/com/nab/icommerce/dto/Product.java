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
 * A product item
 */
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("product")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    private String code;
    private String name;
    private String description;
    private String imageUrl;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private DateTime createdDate;

    @JsonCreator
    public Product(@JsonProperty("code") String code,
                   @JsonProperty("name") String name,
                   @JsonProperty("description") String description,
                   @JsonProperty("imageUrl") String imageUrl,
                   @JsonProperty("createdDate") DateTime createdDate) {
        this.code = notEmpty(code, "code can not be empty");
        this.name = notEmpty(name, "name can not be empty");
        this.description = notNull(description, "description can not be null");
        this.imageUrl = notNull(imageUrl, "imageUrl can not be null");
        this.createdDate = notNull(createdDate, "createdDate can not be null");
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return ObjectToStringBuilder.defaultToString(this);
    }

}
