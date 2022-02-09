package ru.chupikov.service.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chupikov.dao.CityRepository;
import ru.chupikov.entity.CityEntity;

import java.util.List;

/**
 * Сервис с операциями поиска для городов
 */
@Service
public class CitySearchService {

    @Autowired
    CityRepository cityRepository;

    /**
     * Метод поиска всех городов
     *
     * @return список найденных городов, отсортированных по имени
     */
    @Transactional(readOnly = true)
    public List<CityEntity> findAll(){
        return cityRepository.findAll(Sort.by("name"));
    }

    /**
     * Метод поиска города по ID
     *
     * @param id ID города
     * @return Сущность города
     */
    @Transactional(readOnly = true)
    public CityEntity findById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

}
