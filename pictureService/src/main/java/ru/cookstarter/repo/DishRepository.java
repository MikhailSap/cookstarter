package ru.cookstarter.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cookstarter.model.Dish;

import java.util.Optional;

public interface DishRepository extends JpaRepository<Dish, Long> {
    Optional<Dish> findById(Long id);
}
