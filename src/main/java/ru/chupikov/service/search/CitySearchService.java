package ru.chupikov.service.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
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

    public List<CityEntity> findAll(){
        return cityRepository.findAll(Sort.by("name"));
    }


}
