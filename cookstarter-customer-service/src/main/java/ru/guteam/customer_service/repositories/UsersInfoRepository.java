package ru.guteam.customer_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.guteam.customer_service.entities.UsersInfo;

@Repository
public interface UsersInfoRepository extends JpaRepository<UsersInfo, Long> {
    boolean existsByEmail(String email);
}