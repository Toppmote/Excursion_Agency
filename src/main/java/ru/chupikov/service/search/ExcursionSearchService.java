package ru.chupikov.service.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chupikov.dao.ExcursionRepository;
import ru.chupikov.dto.ExcursionModel;
import ru.chupikov.entity.ExcursionEntity;
import ru.chupikov.utils.mapper.ExcursionMapper;

import java.util.List;
import java.util.Optional;

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
    public List<ExcursionModel> findAll() {
        List<ExcursionEntity> excursionEntities = excursionRepository.findAll(Sort.by("date"));
        return ExcursionMapper.entityListToModel(excursionEntities);
    }

    /**
     * Метод поиска экскурсии по ID
     *
     * @param id ID экскурсии
     * @return Сущность экскурсии
     */
    @Transactional(readOnly = true)
    public ExcursionModel findById(Long id) {
        Optional<ExcursionEntity> excursionEntity = excursionRepository.findById(id);
        return excursionEntity.map(ExcursionMapper::entityToModel).orElse(null);
    }

}
