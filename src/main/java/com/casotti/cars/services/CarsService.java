package com.casotti.cars.services;

import com.casotti.cars.domain.cars.Cars;
import com.casotti.cars.exceptions.CarsNotFoundException;
import com.casotti.cars.repositories.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsService {

    @Autowired
    private CarsRepository carsRepository;

    public Cars addCars(Cars cars){
        return carsRepository.save(cars);
    }

    public List<Cars> listAllCars(){
        return carsRepository.findAll();
    }

    public Optional<Cars> listCarsById(Integer id){
        return carsRepository.findById(id);
    }

    public Cars updateCar(Cars cars){
        Optional<Cars> carToUpdate = carsRepository.findById(cars.getId());


        if(carToUpdate.isPresent()){
            Cars updatedCars = carToUpdate.get();

            updatedCars.setModel(cars.getModel());
            updatedCars.setYear(cars.getYear());
            updatedCars.setDoorsNumbers(cars.getDoorsNumbers());
            updatedCars.setColor(cars.getColor());

            return carsRepository.save(updatedCars);
        } else {
            throw new CarsNotFoundException(cars.getId());
        }
    }

    public Cars deleteCar(Integer id){
        Optional<Cars> carToDelete = carsRepository.findById(id);

        if (carToDelete.isPresent()){
            Cars removeCars = carToDelete.get();

            carsRepository.deleteById(removeCars.getId());
            return removeCars;
        } else {
            throw new CarsNotFoundException(id);
        }


    }
}
