package ru.chupikov.service.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chupikov.dao.ExcursionRepository;
import ru.chupikov.entity.ExcursionEntity;

import java.util.List;

/**
 * Сервис с операциями поиска для экскурсий
 */
@Service
public class ExcursionSearchService {

    @Autowired
    ExcursionRepository excursionRepository;

    /**
     * Метод поиска всех экскурсий
     *
     * @return список найденных экскурсий, отсортированных по имени
     */
    @Transactional(readOnly = true)
    public List<ExcursionEntity> findAll() {
        return excursionRepository.findAll(Sort.by("date"));
    }

    /**
     * Метод поиска экскурсии по ID
     *
     * @param id ID экскурсии
     * @return Сущность экскурсии
     */
    @Transactional(readOnly = true)
    public ExcursionEntity findById(Long id) {
        return excursionRepository.findById(id).orElse(null);
    }

}
