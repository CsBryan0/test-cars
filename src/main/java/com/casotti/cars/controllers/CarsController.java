package com.casotti.cars.controllers;

import com.casotti.cars.domain.cars.Cars;
import com.casotti.cars.exceptions.CarsNotFoundException;
import com.casotti.cars.services.CarsService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarsService carsService;

    @PostMapping
    public ResponseEntity<Cars> postCars(@RequestBody Cars cars){
        Cars createCars = carsService.addCars(cars);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCars);
    }

    @GetMapping
    public ResponseEntity<List<Cars>> getAllCars(){
        List<Cars> cars = carsService.listAllCars();
        return ResponseEntity.ok(cars);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Cars> updateCars(@PathVariable Integer id, @RequestBody Cars cars){
        try{
            Cars updated = carsService.updateCar(cars);
            return ResponseEntity.ok(updated);
        } catch (CarsNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCars(@PathVariable Integer id){
        try {
            carsService.deleteCar(id);
            return ResponseEntity.ok().build();
        } catch (CarsNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
