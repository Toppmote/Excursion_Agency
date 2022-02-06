package ru.chupikov.service.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chupikov.dao.ExcursionRepository;

/**
 * Сервис с операциями поиска для экскурсий
 */
@Service
public class ExcursionSearchService {

    @Autowired
    ExcursionRepository excursionRepository;

}
