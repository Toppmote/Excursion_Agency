package ru.lab2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lab2.entity.GuideEntity;

/**
 * Репозиторий для сущности Экскурсовод
 */
@Repository
public interface GuideRepository extends JpaRepository<GuideEntity, Long> {
}
