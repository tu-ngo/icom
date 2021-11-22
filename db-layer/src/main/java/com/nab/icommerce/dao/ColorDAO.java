package com.nab.icommerce.dao;

import com.nab.icommerce.entity.Brand;
import com.nab.icommerce.entity.Category;
import com.nab.icommerce.entity.Color;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD DAO for {@link Color}
 */
public interface ColorDAO extends CrudRepository<Brand, String> {
}
