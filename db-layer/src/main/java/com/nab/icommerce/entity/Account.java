package com.nab.icommerce.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.joda.time.DateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import static org.apache.commons.lang3.Validate.notEmpty;
import static org.apache.commons.lang3.Validate.notNull;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;


/**
 * User account
 */
@Entity
@Table(name = "account")
public class Account implements Serializable {
    private static final long serialVersionUID = -4438200270183190594L;

    @Id
    @Column(name = "user_name")
    private String userName;
    private boolean active;

    @Column(name = "encrypted_password")
    private String encryptedPassword;
    private String role;

    @Column(name = "created_date", columnDefinition = "DATETIME")
    private DateTime createdDate;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;

    public Account(String userName,
                   boolean active,
                   String encryptedPassword,
                   String role,
                   List<Order> orders,
                   DateTime createdDate) {
        this.userName = notEmpty(userName, "userName can not be empty");
        this.active = active;
        this.encryptedPassword = notEmpty(encryptedPassword, "encryptedPassword can not be empty");
        this.role = notEmpty(role, "role can not be empty");
        this.createdDate = notNull(createdDate, "createdDate can not be null");
        this.orders = notNull(orders, "orders can not be null");
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, SHORT_PREFIX_STYLE).toString(this);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Account other = (Account) o;

        return Objects.equals(userName, other.userName);
    }

}
