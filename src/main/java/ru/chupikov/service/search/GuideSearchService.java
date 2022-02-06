package ru.chupikov.service.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chupikov.dao.GuideRepository;

/**
 * Сервис с операциями поиска для экскурсоводов
 */
@Service
public class GuideSearchService {

    @Autowired
    GuideRepository guideRepository;

}
