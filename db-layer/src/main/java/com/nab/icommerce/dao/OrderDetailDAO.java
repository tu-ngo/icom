package com.nab.icommerce.dao;

import com.nab.icommerce.entity.OrderDetail;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD DAO for {@link OrderDetail}
 */
public interface OrderDetailDAO extends CrudRepository<OrderDetail, String> {
}
