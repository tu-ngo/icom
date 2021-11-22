package com.nab.icommerce.controler;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.nab.icommerce.dto.Brand;
import com.nab.icommerce.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * Creates a new brand
     *
     * @param brand DTO with the new brand
     * @return HTTP entity with the creation task
     */
    @PostMapping(path = "/icom/brands/")
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        com.nab.icommerce.entity.Brand brandEntity = new com.nab.icommerce.entity.Brand(brand.getCode(), brand.getName(), brand.getDescription());
        brandService.createOrUpdate(brandEntity);
        return ResponseEntity.ok(brand);
    }

    @GetMapping(path = "/icom/brands/")
    public ResponseEntity<List<Brand>> listBrands() {
        List<Brand> brands = new ArrayList<>();
        brandService.getAllBrands()
                .forEach(brand -> brands.add(new Brand(brand.getCode(), brand.getName(), brand.getDescription())));
        return ResponseEntity.ok(brands);
    }

    @GetMapping(path = "/icom/brands/find")
    public ResponseEntity<List<Brand>> findBrand(@RequestParam(value = "offset", defaultValue = "0")String title) {
        List<Brand> brands = new ArrayList<>();
        brandService.findBrands(title)
                .forEach(brand -> brands.add(new Brand(brand.getCode(), brand.getName(), brand.getDescription())));
        return ResponseEntity.ok(brands);
    }

    @DeleteMapping(path = "/icom/brands/{brandCode}")
    public ResponseEntity<Brand> deleteBrand(@PathVariable String brandCode) {
        brandService.deleteById(brandCode);
        return new ResponseEntity(new HttpHeaders(), HttpStatus.NO_CONTENT);
    }
}


