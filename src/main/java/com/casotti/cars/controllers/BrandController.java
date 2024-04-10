package com.casotti.cars.controllers;


import com.casotti.cars.domain.brand.Brand;
import com.casotti.cars.exceptions.BrandNotFoundException;
import com.casotti.cars.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<Brand> postBrand(@RequestBody Brand brand){
        Brand createdBrand = brandService.addBrand(brand);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBrand);
    }

    @GetMapping
    public ResponseEntity<List<Brand>> getAllBrands(){
        List<Brand> brands = brandService.getAllBrands();
        return ResponseEntity.ok(brands);
    }

    @PutMapping("/{brandId}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Integer brandId, @RequestBody Brand updatedBrand){
        try {
            Brand updated = brandService.updateBrand(brandId, updatedBrand);
            return ResponseEntity.ok(updated);
        } catch (BrandNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Integer id) {
        try {
            brandService.deleteBrand(id);
            return ResponseEntity.ok().build();
        } catch (BrandNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

