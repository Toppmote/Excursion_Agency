package ru.chupikov.service.crud;

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
        GuideEntity guide = GuideMapper.formToEntity(guideForm);
        if (guideForm.getPhoto().getSize() == 0)
            guide.setPhoto(ImgTransformationUtils.getInstance().getByteEmptyPicture());
        else
            guide.setPhoto(guideForm.getPhoto().getBytes());
        guideRepository.save(guide);
    }

    /**
     * Процедура удаления экскурсовода по ID из БД
     *
     * @param id ID экскурсовода
     */
    @Transactional
    public void deleteById(Long id) {
        guideRepository.deleteById(id);
    }

    /**
     * Процедура обновления экскурсовода в БД
     *
     * @param guideForm форма с новыми данными экскурсовода
     * @throws IOException исключение в случае ошибки доступа (при сбое временного хранилища)
     */
    @Transactional
    public void update(GuideForm guideForm) throws IOException {
        Optional<GuideEntity> guide = guideRepository.findById(guideForm.getId());
        if (guide.isPresent()) {
            GuideEntity updatedGuide = GuideMapper.formToEntity(guideForm);
            if (guideForm.getPhoto().getSize() == 0)
                updatedGuide.setPhoto(guide.get().getPhoto());
            else
                updatedGuide.setPhoto(guideForm.getPhoto().getBytes());
            guideRepository.save(updatedGuide);
        }
    }

}
