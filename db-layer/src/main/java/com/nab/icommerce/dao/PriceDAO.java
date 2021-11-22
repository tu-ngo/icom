package com.nab.icommerce.dao;

import com.nab.icommerce.entity.Brand;
import com.nab.icommerce.entity.Price;
import com.nab.icommerce.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * CRUD DAO for {@link Price}
 */
public interface PriceDAO extends PagingAndSortingRepository<Price, String> {

    /**
     * Finds latest price for a product
     *
     * @param productCode product code
     * @return products
     */
    @Query("SELECT p FROM Price p  WHERE p.product.code = ':productCode' ORDER BY p.startDate DESC")
    List<Price> findProductPrice(@Param("productCode") String productCode, Pageable pageable);
}
