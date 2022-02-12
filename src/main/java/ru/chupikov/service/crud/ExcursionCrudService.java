package ru.chupikov.service.crud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chupikov.dao.CityRepository;
import ru.chupikov.dao.ExcursionRepository;
import ru.chupikov.dao.GuideRepository;
import ru.chupikov.entity.CityEntity;
import ru.chupikov.entity.ExcursionEntity;
import ru.chupikov.entity.GuideEntity;
import ru.chupikov.form.ExcursionForm;
import ru.chupikov.utils.mapper.ExcursionMapper;

import java.util.Optional;

/**
 * Сервис с Crud операциями для экскурсий
 */
@Service
@Slf4j
public class ExcursionCrudService {

    @Autowired
    ExcursionRepository excursionRepository;

    @Autowired
    GuideRepository guideRepository;

    @Autowired
    CityRepository cityRepository;

    /**
     * Процедура сохранения новой экскурсии в БД
     *
     * @param excursionForm форма с данными новой экскурсии
     */
    @Transactional
    public void save(ExcursionForm excursionForm) {
        log.info("[ExcursionCrudService]\tEntered save method");
        Optional<CityEntity> city = cityRepository.findById(excursionForm.getCityId());
        Optional<GuideEntity> guide = guideRepository.findById(excursionForm.getGuideId());
        if (city.isPresent() && guide.isPresent()) {
            ExcursionEntity excursion = ExcursionMapper.formToEntity(excursionForm);
            excursion.setCity(city.get());
            excursion.setGuide(guide.get());
            excursionRepository.save(excursion);
            log.info("[ExcursionCrudService]\tSuccessfully saved excursion");
        }
        log.info("[ExcursionCrudService]\tExit save method");
    }

    /**
     * Процедура удаления экскурсии по ID из БД
     *
     * @param id ID удаляемой экскурсии
     */
    @Transactional
    public void deleteById(Long id) {
        log.info("[ExcursionCrudService]\tEntered deleteById method");
        excursionRepository.deleteById(id);
        log.info("[ExcursionCrudService]\tSuccessfully deleted excursion with id = " + id);
    }

    /**
     * Процедура обновления экскурсии в БД
     *
     * @param excursionForm форма с новыми данными экскурсии
     */
    @Transactional
    public void update(ExcursionForm excursionForm) {
        log.info("[ExcursionCrudService]\tEntered update method");
        if (excursionRepository.findById(excursionForm.getId()).isPresent()) {
            Optional<GuideEntity> guide = guideRepository.findById(excursionForm.getGuideId());
            Optional<CityEntity> city = cityRepository.findById(excursionForm.getCityId());
            if (city.isPresent() && guide.isPresent()) {
                ExcursionEntity updatedExcursion = ExcursionMapper.formToEntity(excursionForm);
                updatedExcursion.setCity(city.get());
                updatedExcursion.setGuide(guide.get());
                excursionRepository.save(updatedExcursion);
                log.info("[ExcursionCrudService]\tSuccessfully updated excursion with id = " + excursionForm.getId());
            }
        }
        log.info("[ExcursionCrudService]\tExit update method");
    }

}