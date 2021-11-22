package com.nab.icommerce.dao;

import com.nab.icommerce.entity.Brand;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * CRUD DAO for {@link Brand}
 */
public interface BrandDAO extends CrudRepository<Brand, String> {

    /**
     * Finds all {@link Brand} by code or name
     *
     * @param title brand title (code or name)
     * @return brands
     */
    @Query("SELECT b FROM Brand b WHERE b.code LIKE '%:title%'  AND b.name LIKE '%:title%' ")
    List<Brand> findBrandsByCodeOrName(@Param("title") String title);
}
