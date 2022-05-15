package com.example.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {
    //fetch cars by brand
    List<Car> findByBrand(@Param("brand") String brand);

    //fetch cars by color
    List<Car> findByColor(@Param("color") String color);
}
