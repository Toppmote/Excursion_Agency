package ru.lab2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lab2.entity.ExcursionEntity;

/**
 * Репозиторий для сущности Экскурсия
 */
@Repository
public interface ExcursionRepository extends JpaRepository<ExcursionEntity, Long> {
}
