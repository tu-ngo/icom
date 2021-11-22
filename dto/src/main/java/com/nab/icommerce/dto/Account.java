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
 * User account
 */
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("account")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {
    private String userName;
    private boolean active;
    private String encryptedPassword;
    private String role;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private DateTime createdDate;

    @JsonCreator
    public Account(@JsonProperty("userName") String userName,
                   @JsonProperty("active") boolean active,
                   @JsonProperty("encryptedPassword") String encryptedPassword,
                   @JsonProperty("role") String role,
                   @JsonProperty("createdDate") DateTime createdDate) {
        this.userName = notEmpty(userName, "userName can not be empty");
        this.active = active;
        this.encryptedPassword = notEmpty(encryptedPassword, "encryptedPassword can not be empty");
        this.role = notEmpty(role, "role can not be empty");
        this.createdDate = notNull(createdDate, "createdDate can not be null");
    }

    public String getUserName() {
        return userName;
    }

    public boolean isActive() {
        return active;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public String getRole() {
        return role;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return ObjectToStringBuilder.defaultToString(this);
    }

}
