package com.nab.icommerce.service;

import com.nab.icommerce.dao.BrandDAO;
import com.nab.icommerce.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    private BrandDAO brandDAO;

    @Autowired
    public BrandService(BrandDAO brandDAO) {
        this.brandDAO = brandDAO;
    }


    /**
     * Gets all brands.
     * @return all brands
     */
    public Iterable<Brand> getAllBrands() {
        return brandDAO.findAll();
    }

    /**
     * Find brand.
     * @return found brands with codeor name matches title
     */
    public Iterable<Brand> findBrands(String title) {
        return brandDAO.findBrandsByCodeOrName(title);
    }


    /**
     * Create/ Update brand
     * @param brand
     */
    public void createOrUpdate(Brand brand){
        brandDAO.save(brand);
    }

    /**
     * Delete brand
     * @param brand
     */
    public void delete(Brand brand){
        brandDAO.delete(brand);
    }

    /**
     * Delete brand by code
     * @param code
     */
    public void deleteById(String code){
        brandDAO.deleteById(code);
    }
}
