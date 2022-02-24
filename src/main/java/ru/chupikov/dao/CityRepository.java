package ru.chupikov.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.chupikov.entity.CityEntity;

import java.util.List;

/**
 * Репозиторий для сущности Город
 */
@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

    /**
     * Метод поиска города по имени
     *
     * @param name имя города
     * @return сущность города
     */
    CityEntity findByName(String name);

    /**
     * Метод поиска городов по фрагменту имени, игнорируя регистр
     *
     * @param nameFragment фрагмент имени
     * @return список городов
     */
    List<CityEntity> findByNameIgnoreCaseContaining(String nameFragment);

}
