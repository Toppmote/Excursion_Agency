package ru.chupikov.service.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chupikov.dao.GuideRepository;
import ru.chupikov.entity.GuideEntity;

import java.util.List;

/**
 * Сервис с операциями поиска для экскурсоводов
 */
@Service
public class GuideSearchService {

    @Autowired
    GuideRepository guideRepository;

    /**
     * Метод поиска всех экскурсоводов
     *
     * @return список найденных экскурсоводов, отсортированных по имени
     */
    @Transactional(readOnly = true)
    public List<GuideEntity> findAll() {
        return guideRepository.findAll(Sort.by("name"));
    }

    /**
     * Метод поиска эксурсовода по заданному id
     *
     * @param id id эксурсовода
     * @return Сущность экскурсовода
     */
    @Transactional(readOnly = true)
    public GuideEntity findById(Long id) {
        return guideRepository.findById(id).orElse(null);
    }

}
