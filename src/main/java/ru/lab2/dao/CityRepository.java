package ru.lab2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lab2.entity.CityEntity;

/**
 * Репозиторий для сущности Город
 */
@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {
}
