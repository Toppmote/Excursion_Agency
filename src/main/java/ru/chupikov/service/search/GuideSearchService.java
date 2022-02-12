package ru.chupikov.service.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chupikov.dao.GuideRepository;
import ru.chupikov.dto.GuideModel;
import ru.chupikov.entity.GuideEntity;
import ru.chupikov.utils.mapper.GuideMapper;

import java.util.List;
import java.util.Optional;

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
    public List<GuideModel> findAll() {
        List<GuideEntity> guideEntities = guideRepository.findAll(Sort.by("name"));
        return GuideMapper.entityListToModel(guideEntities);
    }

    /**
     * Метод поиска эксурсовода по заданному id
     *
     * @param id id эксурсовода
     * @return Сущность экскурсовода
     */
    @Transactional(readOnly = true)
    public GuideModel findById(Long id) {
        Optional<GuideEntity> guideEntity = guideRepository.findById(id);
        return guideEntity.map(GuideMapper::entityToModel).orElse(null);
    }

}
