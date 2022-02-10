package ru.chupikov.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chupikov.dao.GuideRepository;
import ru.chupikov.entity.GuideEntity;
import ru.chupikov.form.GuideForm;
import ru.chupikov.utils.DateUtils;
import ru.chupikov.utils.ImgTransformationUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * Сервис с Crud операциями для экскурсоводов
 */
@Service
public class GuideCrudService {

    @Autowired
    GuideRepository guideRepository;

    /**
     * Процедура сохранения нового экскурсовода
     *
     * @param guideForm форма нового экскурсовода
     */
    @Transactional
    public void save(GuideForm guideForm) throws IOException {
        GuideEntity guide = GuideEntity.builder()
                .name(guideForm.getName())
                .surname(guideForm.getSurname())
                .description(guideForm.getDescription())
                .build();
        guide.setBirthdate(DateUtils.parseDate(guideForm.getBirthdate()));
        if (guideForm.getPhoto().getSize() == 0)
            guide.setPhoto(ImgTransformationUtils.getInstance().getByteEmptyPicture());
        else
            guide.setPhoto(guideForm.getPhoto().getBytes());
        guideRepository.save(guide);
    }

    /**
     * Процедура удаления экскурсовода по ID
     *
     * @param id ID экскурсовода
     */
    @Transactional
    public void deleteById(Long id) {
        guideRepository.deleteById(id);
    }

    @Transactional
    public void update(GuideForm guideForm) throws IOException {
        Optional<GuideEntity> guide = guideRepository.findById(guideForm.getId());
        if (guide.isPresent()) {
            GuideEntity updatedGuide = GuideEntity.builder()
                    .id(guideForm.getId())
                    .name(guideForm.getName())
                    .surname(guideForm.getSurname())
                    .description(guideForm.getDescription())
                    .build();
            updatedGuide.setBirthdate(DateUtils.parseDate(guideForm.getBirthdate()));
            if (guideForm.getPhoto().getSize() == 0)
                updatedGuide.setPhoto(guide.get().getPhoto());
            else
                updatedGuide.setPhoto(guideForm.getPhoto().getBytes());
            guideRepository.save(updatedGuide);
        }
    }

}
