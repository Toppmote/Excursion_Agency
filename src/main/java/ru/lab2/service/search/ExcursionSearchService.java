package ru.lab2.service.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lab2.dao.ExcursionRepository;

/**
 * Сервис с операциями поиска для экскурсий
 */
@Service
public class ExcursionSearchService {

    @Autowired
    ExcursionRepository excursionRepository;

}
