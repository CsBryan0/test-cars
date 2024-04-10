package com.casotti.cars.repositories;

import com.casotti.cars.domain.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
