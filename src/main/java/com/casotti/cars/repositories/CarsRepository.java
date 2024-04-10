package com.casotti.cars.repositories;

import com.casotti.cars.domain.cars.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Cars, Integer> {
}
