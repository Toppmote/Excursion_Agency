package ru.chupikov.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.chupikov.entity.CityEntity;

/**
 * Репозиторий для сущности Город
 */
@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

    CityEntity findByName(String name);

}
