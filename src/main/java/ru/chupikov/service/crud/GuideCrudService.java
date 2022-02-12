package ru.chupikov.service.crud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chupikov.dao.GuideRepository;
import ru.chupikov.entity.GuideEntity;
import ru.chupikov.form.GuideForm;
import ru.chupikov.utils.ImgTransformationUtils;
import ru.chupikov.utils.mapper.GuideMapper;

import java.io.IOException;
import java.util.Optional;

/**
 * Сервис с Crud операциями для экскурсоводов
 */
@Service
@Slf4j
public class GuideCrudService {

    @Autowired
    GuideRepository guideRepository;

    /**
     * Процедура сохранения нового экскурсовода в БД
     *
     * @param guideForm форма с данными нового экскурсовода
     */
    @Transactional
    public void save(GuideForm guideForm) throws IOException {
        log.info("[GuideCrudService]\tEntered save method");
        GuideEntity guide = GuideMapper.formToEntity(guideForm);
        if (guideForm.getPhoto().getSize() == 0)
            guide.setPhoto(ImgTransformationUtils.getInstance().getByteEmptyPicture());
        else
            guide.setPhoto(guideForm.getPhoto().getBytes());
        guideRepository.save(guide);
        log.info("[GuideCrudService]\tSuccessfully saved guide");
    }

    /**
     * Процедура удаления экскурсовода по ID из БД
     *
     * @param id ID экскурсовода
     */
    @Transactional
    public void deleteById(Long id) {
        log.info("[GuideCrudService]\tEntered deleteById method");
        guideRepository.deleteById(id);
        log.info("[GuideCrudService]\tSuccessfully deleted guide with id = " + id);
    }

    /**
     * Процедура обновления экскурсовода в БД
     *
     * @param guideForm форма с новыми данными экскурсовода
     * @throws IOException исключение в случае ошибки доступа (при сбое временного хранилища)
     */
    @Transactional
    public void update(GuideForm guideForm) throws IOException {
        log.info("[GuideCrudService]\tEntered update method");
        Optional<GuideEntity> guide = guideRepository.findById(guideForm.getId());
        if (guide.isPresent()) {
            GuideEntity updatedGuide = GuideMapper.formToEntity(guideForm);
            if (guideForm.getPhoto().getSize() == 0)
                updatedGuide.setPhoto(guide.get().getPhoto());
            else
                updatedGuide.setPhoto(guideForm.getPhoto().getBytes());
            guideRepository.save(updatedGuide);
            log.info("[GuideCrudService]\tSuccessfully updated guide with id = " + guideForm.getId());
        }
        log.info("[GuideCrudService]\tExit update method");
    }

}
