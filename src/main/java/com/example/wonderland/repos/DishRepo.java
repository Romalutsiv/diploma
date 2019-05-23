package com.example.wonderland.repos;

import com.example.wonderland.domain.Dish;
import com.example.wonderland.domain.DishType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DishRepo extends CrudRepository<Dish, Long> {

    Page<Dish> findByDishType(DishType type, Pageable pageable);
    Page<Dish> findAll(Pageable pageable);
    Optional<Dish> findById(Long id);


}
