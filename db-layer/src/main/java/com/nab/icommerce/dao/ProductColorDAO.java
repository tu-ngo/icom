package com.nab.icommerce.dao;

import com.nab.icommerce.entity.ProductColor;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD DAO for {@link ProductColor}
 */
public interface ProductColorDAO extends CrudRepository<ProductColor, String> {
}
