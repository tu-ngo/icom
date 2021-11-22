package com.nab.icommerce.dao;

import com.nab.icommerce.entity.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD DAO for {@link Account}
 */
public interface AccountDAO extends CrudRepository<Account, String> {
}
