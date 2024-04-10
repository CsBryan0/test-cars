package com.casotti.cars.services;

import com.casotti.cars.domain.brand.Brand;
import com.casotti.cars.exceptions.BrandNotFoundException;
import com.casotti.cars.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Brand addBrand(Brand brand){
        return brandRepository.save(brand);
    }

    public List<Brand> getAllBrands(){
        return brandRepository.findAll();
    }

    public Optional<Brand> getBrandsById(Integer id){
        return brandRepository.findById(id);
    }

    public Brand updateBrand(Integer brandId, Brand brand){
        Optional<Brand> brandToUpdate = brandRepository.findById(brandId);

        if(brandToUpdate.isPresent()){
            Brand updatedMarca = brandToUpdate.get();
            updatedMarca.setBrandName(brand.getBrandName());

            return brandRepository.save(updatedMarca);
        } else {
            throw new BrandNotFoundException(brandId);
        }

    }

    public Brand deleteBrand(Integer id){
        Optional<Brand> brandToDelete = brandRepository.findById(id);

        if (brandToDelete.isPresent()){
            Brand removeBrand = brandToDelete.get();
            brandRepository.deleteById(removeBrand.getId());
            return removeBrand;
        }else {
            throw new BrandNotFoundException(id);
        }

    }

}
