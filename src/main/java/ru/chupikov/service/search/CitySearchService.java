package ru.chupikov.service.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chupikov.dao.CityRepository;

/**
 * Сервис с операциями поиска для городов
 */
@Service
public class CitySearchService {

    @Autowired
    CityRepository cityRepository;

}
