package com.nab.icommerce.dao;

import com.nab.icommerce.entity.ProductCategory;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD DAO for {@link ProductCategory}
 */
public interface ProductCategoryDAO extends CrudRepository<ProductCategory, String> {
}
