package ru.chupikov.service.search;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        log.info("[GuideSearchService]\tEntered findAll method");
        List<GuideEntity> guideEntities = guideRepository.findAll(Sort.by("name"));
        log.info("[GuideSearchService]\tReturning list of guides");
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
        log.info("[GuideSearchService]\tEntered findById method");
        Optional<GuideEntity> guideEntity = guideRepository.findById(id);
        log.info("[GuideSearchService]\tReturning guide with id = " + id);
        return guideEntity.map(GuideMapper::entityToModel).orElse(null);
    }

}
