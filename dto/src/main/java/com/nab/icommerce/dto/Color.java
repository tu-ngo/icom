package com.nab.icommerce.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.nab.icommerce.common.ObjectToStringBuilder;

import static org.apache.commons.lang3.Validate.notEmpty;
import static org.apache.commons.lang3.Validate.notNull;

/**
 * Product color
 */
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("color")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Color {
    private String code;
    private String name;
    private String description;

    @JsonCreator
    public Color(@JsonProperty("code") String code,
                 @JsonProperty("name") String name,
                 @JsonProperty("description") String description) {
        this.code = notEmpty(code, "code can not be empty");
        this.name = notEmpty(name, "name can not be empty");
        this.description = notNull(description, "description can not be null");
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

    @Override
    public String toString() {
        return ObjectToStringBuilder.defaultToString(this);
    }
}
