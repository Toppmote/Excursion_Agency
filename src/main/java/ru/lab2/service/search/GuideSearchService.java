package ru.lab2.service.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lab2.dao.GuideRepository;

/**
 * Сервис с операциями поиска для экскурсоводов
 */
@Service
public class GuideSearchService {

    @Autowired
    GuideRepository guideRepository;

}
