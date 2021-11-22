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
 * A product item
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {
    private static final long serialVersionUID = 7294760359757674178L;

    @Id
    @Column(name = "code", length = 20)
    private String code;
    private String name;
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "create_date", columnDefinition = "DATETIME")
    private DateTime createdDate;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Price> prices;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductBrand> productBrands;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductCategory> productCategories;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductColor> productColors;

    public Product() {
    }

    public Product(String code,
                   String name,
                   String description,
                   String imageUrl,
                   DateTime createdDate) {
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

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public List<ProductBrand> getProductBrands() {
        return productBrands;
    }

    public void setProductBrands(List<ProductBrand> productBrands) {
        this.productBrands = productBrands;
    }

    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

    public List<ProductColor> getProductColors() {
        return productColors;
    }

    public void setProductColors(List<ProductColor> productColors) {
        this.productColors = productColors;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, SHORT_PREFIX_STYLE).toString(this);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Product other = (Product) o;

        return Objects.equals(code, other.code);
    }
}
