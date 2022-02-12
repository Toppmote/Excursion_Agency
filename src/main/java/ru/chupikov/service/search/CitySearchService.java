package ru.chupikov.service.search;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chupikov.dao.CityRepository;
import ru.chupikov.entity.CityEntity;
import ru.chupikov.dto.CityModel;
import ru.chupikov.utils.mapper.CityMapper;

import java.util.List;
import java.util.Optional;

/**
 * Сервис с операциями поиска для городов
 */
@Service
@Slf4j
public class CitySearchService {

    @Autowired
    CityRepository cityRepository;

    /**
     * Метод поиска всех городов
     *
     * @return список найденных городов, отсортированных по имени
     */
    @Transactional(readOnly = true)
    public List<CityModel> findAll(){
        log.info("[CitySearchService]\tEntered findAll method");
        List<CityEntity> cityEntities = cityRepository.findAll(Sort.by("name"));
        log.info("[CitySearchService]\tReturning list of cities");
        return CityMapper.entityListToModel(cityEntities);
    }

    /**
     * Метод поиска города по ID. Переводим доменную модель в канальную
     *
     * @param id ID города
     * @return канальная модель города
     */
    @Transactional(readOnly = true)
    public CityModel findById(Long id) {
        log.info("[CitySearchService]\tEntered findById method");
        Optional<CityEntity> cityEntity = cityRepository.findById(id);
        log.info("[CitySearchService]\tReturning city with id = " + id);
        return cityEntity.map(CityMapper::entityToModel).orElse(null);
    }

}
