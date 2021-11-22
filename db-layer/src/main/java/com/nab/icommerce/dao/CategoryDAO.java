package com.nab.icommerce.dao;

import com.nab.icommerce.entity.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD DAO for {@link Category}
 */
public interface CategoryDAO extends CrudRepository<Category, String> {
}
