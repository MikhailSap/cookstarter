package ru.guteam.customer_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.guteam.customer_service.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findOneByUsername(String username);
    boolean existsByUsername(String username);
}