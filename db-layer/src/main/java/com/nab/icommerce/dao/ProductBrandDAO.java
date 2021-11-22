package com.nab.icommerce.dao;

import com.nab.icommerce.entity.ProductBrand;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD DAO for {@link ProductBrand}
 */
public interface ProductBrandDAO extends CrudRepository<ProductBrand, String> {
}
