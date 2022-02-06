package ru.lab2.service.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lab2.dao.CityRepository;

/**
 * Сервис с операциями поиска для городов
 */
@Service
public class CitySearchService {

    @Autowired
    CityRepository cityRepository;

}
