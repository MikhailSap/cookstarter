package ru.cookstarter.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cookstarter.model.Picture;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
