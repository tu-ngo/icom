package com.nab.icommerce.dao;

import com.nab.icommerce.entity.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD DAO for {@link Order}
 */
public interface OrderDAO extends CrudRepository<Order, String> {
}
