package com.nab.icommerce.dao;

import com.nab.icommerce.entity.Brand;
import com.nab.icommerce.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * CRUD DAO for {@link Product}
 */
public interface ProductDAO extends CrudRepository<Product, String> {

    /**
     * Finds all {@link Product} by code or name or description
     *
     * @param title product title (code or name or description)
     * @return products
     */
    @Query("SELECT p FROM Product p  WHERE p.code LIKE '%:title%'  OR p.name LIKE '%:title%'  OR p.description LIKE '%:title%' ")
    List<Brand> findProductsByTitle(@Param("title") String title);


    /**
     * Finds all {@link Product} by brand, category, name
     *
     * @param title product title (code or name or description)
     * @return products
     */
    @Query("SELECT p FROM Product p  WHERE p.code LIKE '%:title%'  OR p.name LIKE '%:title%'  OR p.description LIKE '%:title%' ")
    List<Product> findProductsByManyCriterias(@Param("title") String title);
}
