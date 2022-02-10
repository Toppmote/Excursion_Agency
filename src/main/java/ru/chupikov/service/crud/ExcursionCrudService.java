package ru.chupikov.service.crud;

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
import ru.chupikov.utils.DateUtils;

import java.util.Optional;

/**
 * Сервис с Crud операциями для экскурсий
 */
@Service
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
        Optional<CityEntity> city = cityRepository.findById(excursionForm.getCityId());
        Optional<GuideEntity> guide = guideRepository.findById(excursionForm.getGuideId());
        if (city.isPresent() && guide.isPresent()) {
            ExcursionEntity excursion = ExcursionEntity.builder()
                    .name(excursionForm.getName())
                    .description(excursionForm.getDescription())
                    .date(DateUtils.parseDate(excursionForm.getDate()))
                    .city(city.get())
                    .guide(guide.get())
                    .build();
            excursionRepository.save(excursion);
        }
    }

    /**
     * Процедура удаления экскурсии по ID из БД
     *
     * @param id ID удаляемой экскурсии
     */
    @Transactional
    public void deleteById(Long id) {
        excursionRepository.deleteById(id);
    }

    /**
     * Процедура обновления экскурсии в БД
     *
     * @param excursionForm форма с новыми данными экскурсии
     */
    @Transactional
    public void update(ExcursionForm excursionForm) {
        if (excursionRepository.findById(excursionForm.getId()).isPresent()) {
            Optional<GuideEntity> guide = guideRepository.findById(excursionForm.getGuideId());
            Optional<CityEntity> city = cityRepository.findById(excursionForm.getCityId());
            if (city.isPresent() && guide.isPresent()) {
                ExcursionEntity updatedExcursion = ExcursionEntity.builder()
                        .id(excursionForm.getId())
                        .name(excursionForm.getName())
                        .description(excursionForm.getDescription())
                        .date(DateUtils.parseDate(excursionForm.getDate()))
                        .city(city.get())
                        .guide(guide.get())
                        .build();
                excursionRepository.save(updatedExcursion);
            }
        }
    }

}